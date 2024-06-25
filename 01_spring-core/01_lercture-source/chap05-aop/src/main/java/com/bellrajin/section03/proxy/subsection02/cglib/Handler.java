package com.bellrajin.section03.proxy.subsection02.cglib;


import com.bellrajin.section03.proxy.common.OhgifaggersStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final OhgifaggersStudent student;

    public Handler(OhgifaggersStudent student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("공부가 너무 하고 싶어요");

        method.invoke(student, args);

        System.out.println("왜 벌써 자려구요? 니렙에 잠이오니.");
        return proxy;
    }
}
