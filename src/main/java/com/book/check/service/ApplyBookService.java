package com.book.check.service;

import com.book.check.config.auth.PrincipalDetails;
import com.book.check.model.ApplyBook;
import com.book.check.model.ShareBook;
import com.book.check.model.User;
import com.book.check.repository.ApplyBookRepository;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

@Service
public class ApplyBookService {

    private final ApplyBookRepository applyBookRepository;

    public ApplyBookService(ApplyBookRepository applyBookRepository) {
        this.applyBookRepository = applyBookRepository;
    }

    public void applyBookSave(ApplyBook applyBook, ShareBook shareBook, User user) {
        System.out.println(shareBook.getId());
        applyBook.setShareBook(shareBook);
        applyBook.setUser(user);
        applyBookRepository.save(applyBook);
    }

}
