package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        HttpSession session = req.getSession();
        System.out.println("session id = " + session.getId());

        System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(60 * 10);        //세션의 만료 시간을 10분으로 설정

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        //세션 강제로 만료 시키므로 새롭게 세션 id를 생성시켜줌.(logout 시 사용함.)
        // > logout 방식은 3가지 방식이 있음. null, 시간 만료, invalidate 가 있음
        session.invalidate();

        resp.sendRedirect("redirect");

    }
}
