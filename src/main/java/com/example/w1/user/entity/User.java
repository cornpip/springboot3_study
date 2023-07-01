package com.example.w1.user.entity;

import com.example.w1.user.dto.UserSignUpDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(final UserSignUpDto userSignUpDto, final UserRoleEnum role){
        this.username = userSignUpDto.getUsername();
        this.password = userSignUpDto.getPassword();
        this.email = userSignUpDto.getEmail();
        this.role = role;
    }
}
