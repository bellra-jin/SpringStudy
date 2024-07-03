package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

// Servive
// 주 역할 : 트랜젝션 담당
// 하나의 트랜젝션은 하나의 Connection을 가진다.
public class MenuRegistService {

    public boolean registMenu(MenuDTO menu) {

        Connection con = getConnection();


        //DML 구문 시작
        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.insertMenu(con, menu);

        if (result > 0) {
            commit(con);

        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }
}
