package com.bellrajin.section03.annotationconfig.subsection01.java;

import com.bellrajin.common.MemberDAO;
import com.bellrajin.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);

        System.out.println(memberDAO.findMemberBySeq(1));
        System.out.println(memberDAO.save(new MemberDTO(3, "user03", "pass03", "신사임당")));
        System.out.println(memberDAO.findMemberBySeq(3));
    }
}
