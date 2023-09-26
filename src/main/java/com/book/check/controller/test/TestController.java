package com.book.check.controller.test;

import com.book.check.model.RoleType;
import com.book.check.model.User;
import com.book.check.repository.*;
import com.book.check.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final HowBookRepository howBookRepository;
    private final ApplyBookRepository applyBookRepository;
    private final NotiRepository notiRepository;
    private final ReviewRepository reviewRepository;
    private final ShareBookRepository shareBookRepository;

    private final BCryptPasswordEncoder encoder;

    public TestController(UserService userService, UserRepository userRepository,
                          HowBookRepository howBookRepository,
                          ApplyBookRepository applyBookRepository,
                          NotiRepository notiRepository,
                          ReviewRepository reviewRepository,
                          ShareBookRepository shareBookRepository,
                          BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.howBookRepository = howBookRepository;
        this.applyBookRepository = applyBookRepository;
        this.notiRepository = notiRepository;
        this.reviewRepository = reviewRepository;
        this.shareBookRepository = shareBookRepository;
        this.encoder = encoder;
    }
    @GetMapping("/test/main")
    public String main() {
        return "user/maintest";
    }

    @PostMapping("/test/join")
    public String join(@ModelAttribute User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "/user/maintest";
    }

    @GetMapping("/test/join")
    public String getJoin() {
        return "joinForm";
    }

}
