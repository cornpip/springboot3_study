package com.example.w1.member.dto;

import com.example.w1.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;
    private String pw;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.pw = member.getPw();
    }
}
