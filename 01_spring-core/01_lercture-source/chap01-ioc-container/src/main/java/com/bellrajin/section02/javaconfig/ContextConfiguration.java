package com.bellrajin.section02.javaconfig;

import com.bellrajin.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration을 넣으면 class 자체가 하나의 Bean이 된다.
@Configuration
public class ContextConfiguration {

    @Bean("member")
    public MemberDTO getMember() {

        System.out.println("getMember 호출함...");
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }

}
