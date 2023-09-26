package com.book.check.controller.api;

import com.book.check.dto.ResponseDTO;
import com.book.check.model.Review;
import com.book.check.model.User;
import com.book.check.repository.UserRepository;
import com.book.check.service.ReviewService;
import com.book.check.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/join")
    public ResponseDTO<Integer> save(@RequestBody User user) {
        userService.save(user);
        return new ResponseDTO<>(HttpStatus.OK.value(), 1);
    }

}
