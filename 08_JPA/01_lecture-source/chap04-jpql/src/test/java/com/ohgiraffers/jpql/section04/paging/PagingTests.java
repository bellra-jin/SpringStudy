package com.ohgiraffers.jpql.section04.paging;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PagingTests {

    @Autowired
    private MenuFinedMenuPagingService menuFinedMenuPagingService;


    @DisplayName("페이징 API를 이용한 조회 테스트")
    @ParameterizedTest
    @CsvSource({"0,5", "1,5"})
    void testFindAllMenuWithPaging(int offset, int limit) {

        Assertions.assertDoesNotThrow(
                () -> {
                    List<Menu> menus = menuFinedMenuPagingService.findAllMenuWithPaging(offset, limit);
                    menus.forEach(System.out::println);
                }

        );
    }

}
