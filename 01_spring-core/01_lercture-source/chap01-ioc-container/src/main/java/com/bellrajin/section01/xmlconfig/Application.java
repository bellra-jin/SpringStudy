package com.bellrajin.section01.xmlconfig;

import com.bellrajin.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        
        //MemberDTO member = (MemberDTO) context.getBean("member");

        //이름과 상관없이 class에 정의된 타입을 꺼내놓음.
        //MemberDTO member = context.getBean(MemberDTO.class);

        // class에 대한 타입을 따로 지정을 해주기 때문에 직접적으로 해당 타입으로 리턴해줄 수 있기 때문에 위에 2가지 방법을 모두 적용 할 수 있다.
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
    }
}
