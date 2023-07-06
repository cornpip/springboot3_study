package com.example.w1.user.controller;

import com.example.w1.exception.util.ExceptionUtil;
import com.example.w1.security.UserDetailsImpl;
import com.example.w1.user.dto.UserResponseDto;
import com.example.w1.user.dto.UserSignUpDto;
import com.example.w1.user.entity.User;
import com.example.w1.user.entity.UserRoleEnum;
import com.example.w1.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

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

    @GetMapping("/test3")
    public HttpEntity<String> test3(HttpServletResponse response) {
//        HashMap<String, String> s = new HashMap<>();
//        s.put("authorization", "123456789");
        LinkedMultiValueMap<String, String> s = new LinkedMultiValueMap<>();
        s.put("authorization", new ArrayList<>(Arrays.asList("0", "1", "2")));
        HttpEntity<String> choi = new HttpEntity<>("choi", s);
        response.setStatus(201);
        return choi;
    }

    @Secured(UserRoleEnum.Authority.ADMIN)
    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return user.getRole().getAuthority();
    }

    @GetMapping("/noadmin")
    public String noAdmin(@AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return user.getRole().getAuthority();
    }
}
