package com.book.check.repository;

import com.book.check.domain.Noti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotiRepository extends JpaRepository<Noti, Integer> {
}
