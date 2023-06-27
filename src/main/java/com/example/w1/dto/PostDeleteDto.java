package com.example.w1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDeleteDto extends PostUserDto{
    private String username;
    private String password;

    PostDeleteDto(String username, String password) {
        super(username, password);
    }
}