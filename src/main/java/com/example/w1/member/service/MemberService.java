package com.example.w1.member.service;

import com.example.w1.member.dto.MemberCreateDto;
import com.example.w1.member.dto.MemberResponseDto;
import com.example.w1.member.entity.Member;
import com.example.w1.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponseDto> getAllMember() {
        return memberRepository.findAll().stream().map(MemberResponseDto::new).toList();
    }

    public MemberResponseDto createMember(MemberCreateDto memberCreateDto) {
        Member member = new Member(memberCreateDto);
        Member saveMember = memberRepository.save(member);
        return new MemberResponseDto(saveMember);
    }

    public MemberResponseDto getMember(Long memberId) {
        return new MemberResponseDto(findMemberById(memberId));
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new NullPointerException("해당 MemberId는 없습니다."));
    }
}
