package com.ohgiraffers.persistence.section02.crud;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.EntityTransaction;
import java.util.stream.Stream;

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


    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of("새로운메뉴", 3000, 4, "Y")
        );
    }


    @DisplayName("새로운 메뉴 츄가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegistMenu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {

        Long count = manager.saveAndReturnAllCount(menuName, menuPrice, categoryCode, orderableStatus);

        Assertions.assertEquals(31, count);
    }


    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("1, 민트미역국")
    void testModifyMenuName(int menuCode, String menuName) {

        Menu menu = manager.modifyMenuName(menuCode, menuName);

        Assertions.assertEquals(menuName, menu.getMenuName());
    }


    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void removeMenu(int menuCode) {

        Long count = manager.removeAndReturnAllCount(menuCode);

        Assertions.assertEquals(29, count);
    }


    @AfterEach
    void rollback() {
        EntityTransaction transaction = manager.getMangerInstance().getTransaction();
        transaction.rollback();
    }

}
