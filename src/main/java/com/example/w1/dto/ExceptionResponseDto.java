package com.example.w1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {
    private HttpStatus httpStatus;
    private String message;
}
