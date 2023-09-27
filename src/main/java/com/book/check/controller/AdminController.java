package com.book.check.controller;

import com.book.check.config.auth.PrincipalDetails;
import com.book.check.model.Noti;
import com.book.check.service.HowBookService;
import com.book.check.service.NotiService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final NotiService notiService;
    private final HowBookService howBookService;

    public AdminController(NotiService notiService, HowBookService howBookService) {
        this.notiService = notiService;
        this.howBookService = howBookService;
    }

    @GetMapping("/noti")
    public String noti(Model model) {
        model.addAttribute("noties", notiService.findAll());
        return "/admin/noti";
    }
    @GetMapping("/noti/add")
    public String notiAddForm() {
        return "/admin/notiAddForm";
    }

    @PostMapping("/noti/add")
    public String notiAdd(@ModelAttribute Noti noti) {
        notiService.saveNoti(noti);
        return "redirect:/admin/noti";
    }
    @GetMapping("/noti/{id}")
    public String notiDetail(@PathVariable int id, Model model) {
        model.addAttribute("noti", notiService.notiDetail(id));
        return "admin/notiDetail";
    }
    @PostMapping("/noti/delete/{id}")
    public String notiDelete(@PathVariable int id) {
        notiService.notiDelete(id);
        return "redirect:/admin/noti";
    }

    @GetMapping("/noti/edit{id}")
    public String notiEdit() {
        return "/admin/noti";
    }




}
