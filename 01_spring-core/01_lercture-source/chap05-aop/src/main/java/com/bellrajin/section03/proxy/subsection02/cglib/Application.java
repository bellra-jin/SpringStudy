package com.bellrajin.section03.proxy.subsection02.cglib;

import com.bellrajin.section03.proxy.common.OhgifaggersStudent;
import org.springframework.cglib.proxy.Enhancer;

public class Application {
    public static void main(String[] args) {

        Handler handler = new Handler(new OhgifaggersStudent());
        OhgifaggersStudent proxy = (OhgifaggersStudent) Enhancer.create(OhgifaggersStudent.class, handler);

        proxy.study(20);
    }
}
