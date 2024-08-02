package com.ohgiraffers.persistence.section02.crud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EntityManagerCRUDTests {

    private EntityManagerCRUD manager;

    @BeforeEach
    void initManager() {
        manager = new EntityManagerCRUD();
    }

    @DisplayName("메뉴 코드로 메뉴 조회")
    // 반복문의 성향을 갖고 있음. 갖고 있는 계수 만큼 실행
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    void testFindMenyByMenuCode(int menuCode, int expected) {

        Menu menu = manager.findMenuByMenuCode(menuCode);

        Assertions.assertEquals(expected, menu.getMenuCode());
    }
}
