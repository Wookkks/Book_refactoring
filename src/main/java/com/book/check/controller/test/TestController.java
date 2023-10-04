package com.book.check.controller.test;

import com.book.check.repository.*;
import com.book.check.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final AdminReviewRepository adminReviewRepository;
    private final ApplyBookRepository applyBookRepository;
    private final NotiRepository notiRepository;
    private final UserReviewRepository userReviewRepository;
    private final ShareBookRepository shareBookRepository;
    private final BCryptPasswordEncoder encoder;

}
