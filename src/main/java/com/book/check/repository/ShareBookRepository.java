package com.book.check.repository;

import com.book.check.model.ShareBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareBookRepository extends JpaRepository<ShareBook, Integer> {
}
