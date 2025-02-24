package com.bellrajin.section02.initdestroy.subsection02.annotation;

import com.bellrajin.common.Beverage;
import com.bellrajin.common.Bread;
import com.bellrajin.common.Product;
import com.bellrajin.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1.getItems() = " + cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2.getItems() = " + cart2.getItems());

        //컨테이너를 강제로 종료함
        ((AnnotationConfigApplicationContext) context).close();
    }
}
