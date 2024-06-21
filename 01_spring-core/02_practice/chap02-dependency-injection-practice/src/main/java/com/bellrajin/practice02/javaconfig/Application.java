package com.bellrajin.practice02.javaconfig;

import com.bellrajin.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // Load the Spring context from the Java configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // Retrieve the BoardDTO bean from the IoC container
        BoardDTO boardDTO = context.getBean("boardDTO", BoardDTO.class);

        // Print the BoardDTO bean to the console
        System.out.println(boardDTO);
    }
}
