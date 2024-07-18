package com.ohgiraffers.configuration;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.mybatistest")
@MapperScan(basePackages = "com.ohgiraffers.mybatistest", annotationClass = Mapper.class)
public class MybatistestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatistestApplication.class, args);
    }

}
