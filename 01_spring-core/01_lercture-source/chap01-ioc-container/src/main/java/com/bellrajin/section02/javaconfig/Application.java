package com.bellrajin.section02.javaconfig;

import com.bellrajin.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
    }
}
