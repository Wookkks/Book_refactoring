package com.book.check.repository;

import com.book.check.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {

}
