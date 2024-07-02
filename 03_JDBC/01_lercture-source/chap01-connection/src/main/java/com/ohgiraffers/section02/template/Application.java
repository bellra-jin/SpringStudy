package com.ohgiraffers.section02.template;

import java.sql.Connection;
import static com.ohgiraffers.section02.template.Template.close;

public class Application {
    public static void main(String[] args) {

        //connection 생성메소드
        Connection con = Template.getConnection();
        System.out.println("con = " + con);

        //connection 닫기 메소드
        close(con);
    }
}
