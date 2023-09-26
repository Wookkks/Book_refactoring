package com.book.check.repository;

import com.book.check.model.ApplyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplyBookRepository extends JpaRepository<ApplyBook, Integer> {

    @Query(value = "SELECT * FROM APPLYBOOK WHERE SHAREID = ?", nativeQuery = true)
    List<ApplyBook> findApplyBookByShareId(int id);
}
