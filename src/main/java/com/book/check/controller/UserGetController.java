package com.book.check.controller;

import com.book.check.config.auth.PrincipalDetails;
import com.book.check.repository.AdminReviewRepository;
import com.book.check.repository.ApplyBookRepository;
import com.book.check.repository.NotiRepository;
import com.book.check.repository.ShareBookRepository;
import com.book.check.service.*;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserGetController {

    private final UserReviewService userReviewService;
    private final ShareBookRepository shareBookRepository;
    private final ApplyBookRepository applyBookRepository;
    private final NotiRepository notiRepository;
    private final NotiService notiService;
    private final AdminReviewService adminReviewService;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        return "user/main";
    }

    @GetMapping("/join")
    public String getJoin(Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        return "user/joinForm";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false)String error, 
    		@RequestParam(value = "exception", required = false)String exception ,Model model) {
    	model.addAttribute("error", error);
    	model.addAttribute("exception", exception);
        model.addAttribute("noties", notiRepository.findAll());
        return "user/loginForm";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "user/accessDenied";
    }

    @GetMapping("/share/{id}")
    public String shareDetail(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principal, Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        model.addAttribute("user", principal.getUser());
        model.addAttribute("shareBook", shareBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다.")));
        return "user/applyForm";
    }

    @GetMapping("/review")
    public String how(Model model, @AuthenticationPrincipal PrincipalDetails principal, @RequestParam(required = false) String month) {
        if(principal == null || principal.getUser() == null) {
            return "user/accessDenied";
        }
        
        if(month == null) {
        	Date date= new Date();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        	month = sdf.format(date);
        }
        
        model.addAttribute("adminReview", adminReviewService.findByMonth(month));
        model.addAttribute("noties", notiRepository.findAll());
        model.addAttribute("userReview", userReviewService.findAll());
        model.addAttribute("userId", principal.getUser().getId());
        return "user/review";
    }

    @GetMapping("/chart")
    public String chart(Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        return "user/chart";
    }
    @GetMapping("/noti")
    public String noti(Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        return "user/noti";
    }
    @GetMapping("/noti/{id}")
    public String notiDetail(@PathVariable int id, Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        model.addAttribute("noti", notiService.notiDetail(id));
        return "user/notiDetail";
    }
    @GetMapping("/privacy")
    public String privacy(Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        return "user/privacy";
    }
    @GetMapping("/share")
    public String share(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        if(principal == null || principal.getUser() == null) {
            return "user/accessDenied";
        }
        model.addAttribute("noties", notiRepository.findAll());
        model.addAttribute("userId", principal.getUser().getId());
        model.addAttribute("share", shareBookRepository.findAll());
        return "user/shareBook";
    }
    @GetMapping("/share/add")
    public String shareAddForm(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
        model.addAttribute("noties", notiRepository.findAll());
        model.addAttribute("userId", principal.getUser().getId());
        model.addAttribute("name", principal.getUser().getName());
        return "user/shareAddForm";
    }

    @GetMapping("/share/current/{id}")
    public String applyList(@PathVariable int id, Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        model.addAttribute("apply", applyBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다.")));
        model.addAttribute("applyList", applyBookRepository.findApplyBookByShareId(id));
        return "user/applyList";
    }

    @GetMapping("/terms")
    public String terms(Model model) {
        model.addAttribute("noties", notiRepository.findAll());
        return "user/terms";
    }
}
