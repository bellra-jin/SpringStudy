package com.ohgiraffers.mapping.section01.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberRegistService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void registerMember(MemberRegistRequestDTO memberInfo) {

        Member member = new Member(
                memberInfo.getMemberId(),
                memberInfo.getMemberPwd(),
                memberInfo.getMemberName(),
                memberInfo.getPhone(),
                memberInfo.getAddress(),
                memberInfo.getEnrollDate(),
                memberInfo.getMemberRole(),
                memberInfo.getStatus()
        );

        memberRepository.save(member);
    }
}
