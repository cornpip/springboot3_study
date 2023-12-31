package com.example.w1.post.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostUserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
