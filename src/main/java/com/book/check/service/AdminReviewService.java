package com.book.check.service;

import com.book.check.model.AdminReview;
import com.book.check.repository.AdminReviewRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class AdminReviewService {

    private final AdminReviewRepository adminReviewRepository;
    
    public AdminReview findHowBook(int id) {
        return adminReviewRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("게시글을 찾을 수 없습니다.");
        });
    }
    
    
    public void saveWithFile(String month, String week, String title, String content, MultipartFile file) {
    	byte[] data;
    	String dataPath = "C:/Users/User/Desktop/file";
		try {
			data = file.getBytes();
			String dataName = file.getOriginalFilename();
			Path imgPath = Paths.get(dataPath, dataName);
			Files.write(imgPath,file.getBytes());
			
			AdminReview review = new AdminReview(month, week, title, content, dataName, data);
			System.out.println(data);
			adminReviewRepository.save(review);
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
