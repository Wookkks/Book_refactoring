package com.book.check.service;

import com.book.check.model.UserReview;
import com.book.check.model.User;
import com.book.check.repository.UserReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {

    private final UserReviewRepository userReviewRepository;

    public UserReviewService(UserReviewRepository userReviewRepository) {
        this.userReviewRepository = userReviewRepository;
    }

    public void saveReview(UserReview review, User user) {
        review.setUser(user);
        userReviewRepository.save(review);
    }

    public List<UserReview> findAll() {
        return userReviewRepository.findAll();
    }
}
