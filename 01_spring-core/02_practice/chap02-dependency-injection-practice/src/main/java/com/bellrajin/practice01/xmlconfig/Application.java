package com.bellrajin.practice01.xmlconfig;

import com.bellrajin.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("practice01/xmlconfig/spring-context.xml");

        // Retrieve the BoardDTO bean from the IoC container
        BoardDTO boardDTO = context.getBean("boardDTO", BoardDTO.class);

        // Print the BoardDTO bean to the console
        System.out.println(boardDTO);
    }
}
