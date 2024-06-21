package com.bellrajin.section01.autowired.subsection03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.bellrajin.section01");

        BookService bookService = (BookService) context.getBean("bookServiceSetter");

        bookService.findAllBooks().forEach(System.out::println);
    }
}