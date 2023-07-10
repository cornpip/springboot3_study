package com.example.w1.study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "memo")
public class Memo {
    @Id
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
}