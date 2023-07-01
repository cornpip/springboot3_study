package com.example.w1.user.dto;

import com.example.w1.user.entity.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String admin;

    public UserResponseDto(final User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.admin = user.getRole().getAuthority();
    }
}
