package com.book.check.controller;

import com.book.check.config.auth.PrincipalDetails;
import com.book.check.model.ApplyBook;
import com.book.check.model.UserReview;
import com.book.check.model.ShareBook;
import com.book.check.repository.ShareBookRepository;
import com.book.check.service.ApplyBookService;
import com.book.check.service.UserReviewService;
import com.book.check.service.ShareBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserPostController {

    private final UserReviewService userReviewService;
    private final ShareBookService shareBookService;
    private final ShareBookRepository shareBookRepository;
    private final ApplyBookService applyBookService;

    @PostMapping("/apply")
    public String apply(@AuthenticationPrincipal PrincipalDetails principal, ApplyBook applyBook, @RequestParam int shareId) {
        ShareBook shareBook = shareBookRepository.findById(shareId).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다."));
        applyBookService.applyBookSave(applyBook, shareBook, principal.getUser());
        return "redirect:/user/share";
    }

    @PostMapping("/review")
    public String howAdd(UserReview review, @AuthenticationPrincipal PrincipalDetails principal) {
        userReviewService.saveReview(review, principal.getUser());
        return "redirect:/user/review";
    }

    @PostMapping("/share/add")
    public String shareAdd(@ModelAttribute ShareBook shareBook, @AuthenticationPrincipal PrincipalDetails principal) {
        shareBookService.saveShareBook(shareBook, principal.getUser());
        return "redirect:/user/share";
    }

    @PostMapping("/share/current")
    public String applyResult(@RequestParam int id, @RequestParam boolean shareYn) {
        System.out.println(shareYn);
        shareBookService.updateShareYn(id, shareYn);
        return "redirect:/user/share";
    }
}
