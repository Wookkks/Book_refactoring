package com.book.check.controller.api;

import com.book.check.dto.ResponseDto;
import com.book.check.model.User;
import com.book.check.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/join")
    public ResponseDto<Integer> save(@RequestBody User user) {
        userService.save(user);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

}
