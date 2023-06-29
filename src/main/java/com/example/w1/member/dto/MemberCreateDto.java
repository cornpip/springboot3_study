package com.example.w1.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberCreateDto {
    private String name;
    private String email;
    private String pw;
}
