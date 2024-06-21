package com.bellrajin.practice02.javaconfig;


import com.bellrajin.common.BoardDTO;
import com.bellrajin.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public MemberDTO memberDTO() {
        MemberDTO member = new MemberDTO();
        member.setId(1L);
        member.setNickname("봄이올까요");
        return member;
    }

    @Bean
    public BoardDTO boardDTO() {
        BoardDTO board = new BoardDTO();
        board.setId(1L);
        board.setTitle("의존성 주입 연습");
        board.setContent("게시글의 작성자 객체를 주입 받아볼게요!");
        board.setWriter(memberDTO()); // memberDTO 빈을 주입
        return board;
    }
}
