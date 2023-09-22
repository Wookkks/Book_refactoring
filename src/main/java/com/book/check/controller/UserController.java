package com.book.check.controller;

import com.book.check.model.User;
import com.book.check.repository.UserRepository;
import com.book.check.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserController(UserService userService, UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/main")
    public String main() {
        return "user/main";
    }

    @GetMapping("/join")
    public String getJoin() {
        return "user/u_joinForm";
    }

    @GetMapping("/login")
    public String login() {
        return "user/u_loginForm";
    }

}
