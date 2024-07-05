package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getCharacterEncoding());
        // tomcat이 10버전에서는 UTF-8이 자동으로 인코딩 되기 때문에 따로 작성 안해줘도 됨.
//        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        Map<String, String[]> requestMap = req.getParameterMap();
        Set<String> keySet = requestMap.keySet();
        Iterator<String> keyIter = keySet.iterator();


        while(keyIter.hasNext()) {
            String key = keyIter.next();
            String[] values = requestMap.get(key);

            System.out.println("key = " + key);
            for (int i = 0; i < values.length; i++) {
                System.out.println("value = " + values[i]);
            }
        }

        Enumeration<String> names =  req.getParameterNames();
        while(names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }

    }
}
