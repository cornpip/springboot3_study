package com.example.w1.user.service;

import com.example.w1.user.dto.UserResponseDto;
import com.example.w1.user.dto.UserSignUpDto;
import com.example.w1.user.entity.User;
import com.example.w1.user.entity.UserRoleEnum;
import com.example.w1.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto signUpUser(UserSignUpDto requestDto) {
        Optional<User> byUsername = userRepository.findByUsername(requestDto.getUsername());
        if (byUsername.isPresent())
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        Optional<User> byEmail = userRepository.findByEmail(requestDto.getEmail());
        if (byEmail.isPresent())
            throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!ADMIN_TOKEN.equals(requestDto.getAdminToken()))
                throw new IllegalArgumentException("올바른 관리자 번호가 아닙니다.");
            role = UserRoleEnum.ADMIN;
        }
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        User user = new User(requestDto, role);
        User saveUser = userRepository.save(user);
        return new UserResponseDto(saveUser);
    }

    public String test() {
        return "test work!";
    }

}
