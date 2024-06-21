package com.bellrajin.practice01.xmlconfig;

import com.bellrajin.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("practice01/xmlconfig/spring-context.xml");

        BoardDTO board = context.getBean("Board", BoardDTO.class);

        System.out.println("board = " + board);
    }
}
