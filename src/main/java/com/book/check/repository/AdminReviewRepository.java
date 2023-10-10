package com.book.check.repository;

import com.book.check.model.AdminReview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminReviewRepository extends JpaRepository<AdminReview, Integer> {
	
	List<AdminReview> findByMonth(String month);
}
