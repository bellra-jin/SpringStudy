package com.bellrajin.section01.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    private final MemberDAO memberDAO;

    public MemberService(final MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> findAllMembers() {

        System.out.println("findAllMembers() 메소드 실행...");
        return memberDAO.findAllMembers();
    }

    public MemberDTO findMemberById(Long id) {

        System.out.println("findMemberById() 메소드 실행...");
        return memberDAO.findMemberById(id);
    }
}
