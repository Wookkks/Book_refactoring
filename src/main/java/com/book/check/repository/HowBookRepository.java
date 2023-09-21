package com.book.check.repository;

import com.book.check.domain.HowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HowBookRepository extends JpaRepository<HowBook, Integer> {
}
