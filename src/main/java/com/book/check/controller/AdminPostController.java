package com.book.check.controller;

import com.book.check.model.AdminReview;
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
    public String reviewAdd(AdminReview adminReview, MultipartFile file) throws Exception{
    	adminReviewService.saveWithFile(adminReview, file);
        return "redirect:/admin/review";
    }
    @PostMapping("/review/edit/{id}")
    public String reviewEdit(@PathVariable int id, AdminReview adminReview, MultipartFile file) throws Exception {
    	AdminReview editReview = adminReviewService.findAdminReview(id);
    	editReview.setMonth(adminReview.getMonth());
    	editReview.setWeek(adminReview.getWeek());
    	editReview.setTitle(adminReview.getTitle());
    	editReview.setContent(adminReview.getContent());
    	adminReviewService.saveWithFile(editReview, file);
    	return "redirect:/admin/review";
    }
    
    @PostMapping("/review/delete/{id}")
    public String reviewDelete(@PathVariable int id) {
        adminReviewService.reviewDelete(id);
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
