package com.example.w1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
public class PostUpdateDto extends PostUserDto {
    private String username;
    private String password;
    private Optional<String> title;
    private Optional<String> contents;

    PostUpdateDto(String username, String password){
        super(username, password);
    }
}
