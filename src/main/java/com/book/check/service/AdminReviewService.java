package com.book.check.service;

import com.book.check.model.AdminReview;
import com.book.check.repository.AdminReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminReviewService {

    private final AdminReviewRepository adminReviewRepository;
    public AdminReview findHowBook(int id) {
        return adminReviewRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("게시글을 찾을 수 없습니다.");
        });
    }
}
