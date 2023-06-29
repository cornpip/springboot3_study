package com.example.w1.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {
    private HttpStatus httpStatus;
    private String message;
}
