package com.example.w1.member.entity;

import com.example.w1.member.dto.MemberCreateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pw", nullable = false)
    private String pw;

    public Member(MemberCreateDto memberCreateDto){
        this.name = memberCreateDto.getName();
        this.email = memberCreateDto.getEmail();
        this.pw = memberCreateDto.getPw();
    }
}
