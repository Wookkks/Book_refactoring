package com.book.check.controller;

import com.book.check.repository.AdminReviewRepository;
import com.book.check.service.AdminReviewService;
import com.book.check.service.NotiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminGetController {

    private final NotiService notiService;
    private final AdminReviewService adminReviewService;
    private final AdminReviewRepository adminReviewRepository;

    @GetMapping("/noti")
    public String noti(Model model) {
        model.addAttribute("noties", notiService.findAll());
        return "admin/noti";
    }
    @GetMapping("/review")
    public String review(Model model) {
        model.addAttribute("noties", notiService.findAll());
        model.addAttribute("review", adminReviewRepository.findAll());
        return  "admin/review";
    }
    @GetMapping("/review/add")
    public String reviewAddForm() {
        return "admin/reviewAddForm";
    }

    @GetMapping("/review/edit/{id}")
    public String reviewEditForm(@PathVariable int id, Model model) {
        model.addAttribute("review", adminReviewService.findHowBook(id));
        return "admin/reviewEditForm";
    }

    @GetMapping("/noti/add")
    public String notiAddForm(Model model) {
        model.addAttribute("noties", notiService.findAll());
        return "admin/notiAddForm";
    }
    @GetMapping("/noti/{id}")
    public String notiDetail(@PathVariable int id, Model model) {
        model.addAttribute("noties", notiService.findAll());
        model.addAttribute("noti", notiService.notiDetail(id));
        return "admin/notiDetail";
    }
    @GetMapping("/noti/edit/{id}")
    public String notiEdit(@PathVariable int id, Model model) {
        model.addAttribute("noties", notiService.findAll());
        model.addAttribute("noti", notiService.notiDetail(id));
        return "admin/notiEditForm";
    }
}
