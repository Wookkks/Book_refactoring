package com.book.check.service;

import com.book.check.model.Noti;
import com.book.check.model.User;
import com.book.check.repository.NotiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotiService {

    private final NotiRepository notiRepository;

    public NotiService(NotiRepository notiRepository) {
        this.notiRepository = notiRepository;
    }

    public void saveNoti(Noti noti) {
        notiRepository.save(noti);
    }

    public List<Noti> findAll() {
        return notiRepository.findAll();
    }

    public Noti notiDetail(int id) {
        return notiRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디를 찾을 수 없습니다."));
    }

    public void notiDelete(int id) {
        Noti noti = notiRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("아이디를 찾을 수 없습니다."));
        notiRepository.delete(noti);
    }
}
