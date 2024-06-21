package com.bellrajin.practice03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.bellrajin")
public class ContextConfiguration {
}
