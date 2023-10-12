package com.book.check.service;

import com.book.check.model.AdminReview;
import com.book.check.repository.AdminReviewRepository;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class AdminReviewService {

    private final AdminReviewRepository adminReviewRepository;
    
    public AdminReview findAdminReview(int id) {
        return adminReviewRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("게시글을 찾을 수 없습니다.");
        });
    }
    
    public void saveWithFile(AdminReview adminReview, MultipartFile file) throws Exception{
    	String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";
    	UUID uuid = UUID.randomUUID();
    	String fileName = uuid + "_" + file.getOriginalFilename();
    	File saveFile = new File(projectPath, fileName);
    	file.transferTo(saveFile);
    	
    	adminReview.setFileName(fileName);
    	adminReview.setFilePath("/files/" + fileName);
    	adminReviewRepository.save(adminReview);
    }
    
    public void reviewDelete(int id) {
    	adminReviewRepository.deleteById(id);
    }
    
    public List<AdminReview> findByMonth(String month) {
    	return adminReviewRepository.findByMonth(month);
    }
}
