package com.example.w1.post.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString(callSuper = true)
public class PostUpdateDto extends PostUserDto {
    private Optional<String> title;
    private Optional<String> contents;

    public PostUpdateDto(String username, String password) {
        super(username, password);
    }
}
