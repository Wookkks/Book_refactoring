package com.book.check.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test/main")
    public String main() {
        return "user/maintest";
    }
}
