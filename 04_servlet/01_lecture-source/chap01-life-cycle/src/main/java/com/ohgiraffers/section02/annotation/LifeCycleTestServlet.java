package com.ohgiraffers.section02.annotation;

import com.ohgiraffers.chap01lifecycle.HelloServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;


@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTestServlet extends HelloServlet {

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }
}
