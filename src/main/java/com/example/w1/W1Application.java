package com.example.w1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class W1Application {

    public static void main(String[] args) {
        SpringApplication.run(W1Application.class, args);
    }

}
