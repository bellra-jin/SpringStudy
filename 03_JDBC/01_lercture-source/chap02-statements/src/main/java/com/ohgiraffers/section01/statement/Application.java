package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class Application {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("조회할 사번을 입력하세요 : ");
//        String empId = sc.nextLine();

        
        // connection 생성
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> empList = null;

        try {
            stmt = con.createStatement();

            // select 시 executeQuery => retrun type ResultSet(조회된 결과 집합)
            // insert, update, delete 시 executeUpdate => return type int(변경된 행의 수)
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE";
            System.out.println(query);

            rset = stmt.executeQuery(query);
            empList = new ArrayList<>();

            // 조회 성공해서 행이 존재하면 employee 생성
            // 조건문만 작성하면 되므로 if, while 상관없음(한 줄 일 경우에는 if)
            while (rset.next()) {
                EmployeeDTO row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));

                empList.add(row);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // connection 닫기
            close(con);
            close(stmt);
            close(rset);
        }

        // 리턴 해줄 위치
        empList.forEach(System.out::println);
    }
}
