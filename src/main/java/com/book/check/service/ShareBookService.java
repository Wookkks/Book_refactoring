package com.book.check.service;

import com.book.check.model.ShareBook;
import com.book.check.model.User;
import com.book.check.repository.ShareBookRepository;
import org.springframework.stereotype.Service;

@Service
public class ShareBookService {

    private final ShareBookRepository shareBookRepository;

    public ShareBookService(ShareBookRepository shareBookRepository) {
        this.shareBookRepository = shareBookRepository;
    }

    public void saveShareBook(ShareBook shareBook, User user) {
        shareBook.setUser(user);
        shareBookRepository.save(shareBook);
    }

    public void updateShareYn(int id, boolean shareYn) {
        ShareBook shareBook = shareBookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글을 찾을 수 없습니다."));
        shareBook.setShareYn(shareYn);
        shareBookRepository.save(shareBook);
    }

}
