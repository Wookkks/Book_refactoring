package com.book.check.repository;

import com.book.check.model.Noti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotiRepository extends JpaRepository<Noti, Integer> {
}
