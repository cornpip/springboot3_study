package com.example.w1.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserSignUpDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}
