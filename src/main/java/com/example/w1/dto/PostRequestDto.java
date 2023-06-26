package com.example.w1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;

    @Override
    public String toString() {
        return String.format("username = %s\npassword = %s\ntitle = %s\ncontents = %s", username, password, title, contents);
    }
}
