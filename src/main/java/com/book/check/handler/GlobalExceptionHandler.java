package com.book.check.handler;

import com.book.check.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ModelAndView handelUsernameNotFoundException(UsernameNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseDTO<String> handleArgumentException(Exception e) {
//        System.out.println("GlobalExceptionHandler");
//        return new ResponseDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//    }
}
