package com.example.w1.user.controller;

import com.example.w1.exception.util.ExceptionUtil;
import com.example.w1.security.UserDetailsImpl;
import com.example.w1.user.dto.UserResponseDto;
import com.example.w1.user.dto.UserSignUpDto;
import com.example.w1.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserResponseDto signUpUser(@Valid UserSignUpDto requestDto, BindingResult bindingResult) {
        ExceptionUtil.bindingResultHandle(bindingResult);
        return userService.signUpUser(requestDto);
    }

    @GetMapping("/test")
    public String test() {
        return userService.test();
    }

    @GetMapping("/test2")
    public String test2(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.test();
    }
}
