package com.example.w1.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostCreateDto {
    private String title;
    private String username;
    private String contents;
    private String password;
}
