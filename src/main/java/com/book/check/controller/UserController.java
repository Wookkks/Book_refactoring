package com.book.check.controller;

import com.book.check.config.auth.PrincipalDetails;
import com.book.check.model.ApplyBook;
import com.book.check.model.Review;
import com.book.check.model.ShareBook;
import com.book.check.model.User;
import com.book.check.repository.ApplyBookRepository;
import com.book.check.repository.ShareBookRepository;
import com.book.check.repository.UserRepository;
import com.book.check.service.ApplyBookService;
import com.book.check.service.ReviewService;
import com.book.check.service.ShareBookService;
import com.book.check.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final ReviewService reviewService;
    private final ShareBookService shareBookService;
    private final ShareBookRepository shareBookRepository;
    private final ApplyBookService applyBookService;
    private final ApplyBookRepository applyBookRepository;
    public UserController(UserService userService, UserRepository userRepository, BCryptPasswordEncoder encoder, ReviewService reviewService, ShareBookService shareBookService, ShareBookRepository shareBookRepository, ApplyBookService applyBookService, ApplyBookRepository applyBookRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.reviewService = reviewService;
        this.shareBookService = shareBookService;
        this.shareBookRepository = shareBookRepository;
        this.applyBookService = applyBookService;
        this.applyBookRepository = applyBookRepository;
    }

    @GetMapping("/main")
    public String main() {
        return "user/main";
    }

    @GetMapping("/join")
    public String getJoin() {
        return "user/joinForm";
    }

    @GetMapping("/login")
    public String login() {
        return "user/loginForm";
    }

    @GetMapping("/share/{id}")
    public String shareDetail(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principal, Model model) {
        model.addAttribute("user", principal.getUser());
        model.addAttribute("shareBook", shareBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다.")));
        return "user/applyForm";
    }

    @PostMapping("/apply")
    public String apply(@AuthenticationPrincipal PrincipalDetails principal, ApplyBook applyBook, @RequestParam int shareId) {
        ShareBook shareBook = shareBookRepository.findById(shareId).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다."));
        applyBookService.applyBookSave(applyBook, shareBook, principal.getUser());
        return "redirect:/user/share";
    }

    @GetMapping("/how")
    public String how(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        model.addAttribute("userReview", reviewService.findAll());
        model.addAttribute("userId", principal.getUser().getId());
        return "user/review";
    }

    @PostMapping("/how")
    public String howAdd(Review review, @AuthenticationPrincipal PrincipalDetails principal) {
        reviewService.saveReview(review, principal.getUser());
        return "redirect:/user/how";
    }

    @GetMapping("/chart")
    public String chart() {
        return "user/chart";
    }
    @GetMapping("/noti")
    public String noti() {
        return "user/noti";
    }
    @GetMapping("/noti/{id}")
    public String notiDetail() {
        return "user/notiDetail";
    }
    @GetMapping("/privacy")
    public String privacy() {
        return "user/privacy";
    }
    @GetMapping("/share")
    public String share(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        model.addAttribute("userId", principal.getUser().getId());
        model.addAttribute("share", shareBookRepository.findAll());
        return "user/shareBook";
    }
    @GetMapping("/share/add")
    public String shareAddForm(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        model.addAttribute("userId", principal.getUser().getId());
        model.addAttribute("name", principal.getUser().getName());
        return "user/shareAddForm";
    }
    @PostMapping("/share/add")
    public String shareAdd(@ModelAttribute ShareBook shareBook, @AuthenticationPrincipal PrincipalDetails principal) {
        shareBookService.saveShareBook(shareBook, principal.getUser());
        return "redirect:/user/share";
    }
    @GetMapping("/share/current/{id}")
    public String applyList(@PathVariable int id, Model model) {
        model.addAttribute("apply", applyBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다.")));
        model.addAttribute("applyList", applyBookRepository.findApplyBookByShareId(id));
        return "user/applyList";
    }

    @PostMapping("/share/current")
    public String applyResult(@RequestParam int id, @RequestParam boolean shareYn) {
        System.out.println(shareYn);
        shareBookService.updateShareYn(id, shareYn);
        return "redirect:/user/share";
    }

    @GetMapping("/terms")
    public String terms() {
        return "user/terms";
    }
}
