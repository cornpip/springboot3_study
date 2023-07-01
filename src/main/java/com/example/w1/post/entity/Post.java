package com.example.w1.post.entity;

import com.example.w1.post.dto.PostCreateDto;
import com.example.w1.post.dto.PostUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "contents", length = 500)
    private String contents;

    @Column(name = "password", nullable = false)
    private String password;

    public Post(final PostCreateDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(final PostUpdateDto requestDto){
        if(Optional.ofNullable(requestDto.getTitle()).isPresent()) setTitle(requestDto.getTitle().get());
        if(Optional.ofNullable(requestDto.getContents()).isPresent()) setContents(requestDto.getContents().get());
//        System.out.println(this);
    }
}
