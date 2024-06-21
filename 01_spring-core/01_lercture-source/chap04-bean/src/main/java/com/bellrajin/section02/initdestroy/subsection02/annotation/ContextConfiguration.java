package com.bellrajin.section02.initdestroy.subsection02.annotation;

import com.bellrajin.common.Beverage;
import com.bellrajin.common.Bread;
import com.bellrajin.common.Product;
import com.bellrajin.common.ShoppingCart;
import com.bellrajin.section02.initdestroy.subsection01.java.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.bellrajin.section02.initdestroy.subsection02.annotation")
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 500);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }


}
