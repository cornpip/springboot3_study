package com.example.w1.exception.controller;

import com.example.w1.exception.dto.ExceptionResponseDto;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionResponseDto> validateExceptionHandler(ValidationException e) {
        HttpStatus httpstatus = HttpStatus.BAD_REQUEST;
        ExceptionResponseDto response = new ExceptionResponseDto(httpstatus, e.getMessage());
        return new ResponseEntity<>(response, httpstatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseDto> postExceptionHandler(IllegalArgumentException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ExceptionResponseDto response = new ExceptionResponseDto(httpStatus, e.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }
}
