package com.book.check.controller;

import com.book.check.model.Noti;
import com.book.check.service.AdminReviewService;
import com.book.check.service.NotiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminPostController {

    private final NotiService notiService;
    private final AdminReviewService adminReviewService;

    @PostMapping("/noti/add")
    public String notiAdd(@ModelAttribute Noti noti) {
        notiService.saveNoti(noti);
        return "redirect:/admin/noti";
    }
    @PostMapping("/review/add")
    public String reviewAdd(String month, String week, String title, String content, MultipartFile file) {
    	adminReviewService.saveWithFile(month, week, title, content, file);
        return "redirect:/admin/review";
    }
    @PostMapping("/noti/delete/{id}")
    public String notiDelete(@PathVariable int id) {
        notiService.notiDelete(id);
        return "redirect:/admin/noti";
    }

    @PostMapping("/noti/update")
    public String nodiUpdate() {
        return "redirect:/admin/noti";
    }
}
