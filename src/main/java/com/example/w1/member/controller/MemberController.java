package com.example.w1.member.controller;

import com.example.w1.exception.dto.ExceptionResponseDto;
import com.example.w1.member.dto.MemberCreateDto;
import com.example.w1.member.dto.MemberResponseDto;
import com.example.w1.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("")
    public MemberResponseDto createMember(MemberCreateDto memberCreateDto){
        return memberService.createMember(memberCreateDto);
    }

    @GetMapping("/{memberId}")
    public MemberResponseDto getMember(@PathVariable Long memberId){
        return memberService.getMember(memberId);
    }

    @GetMapping("/all")
    public List<MemberResponseDto> getAllMember(){
        return memberService.getAllMember();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponseDto> memberExceptionHandler(NullPointerException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ExceptionResponseDto response = new ExceptionResponseDto(httpStatus, e.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }
}
