package com.ohgiraffers.jpql.section03.projection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ProjectionTests {

    // 프로젝션
    // Select 절에 조회할 대상을 지정하는 것을 프로젝션이라고 한다.
    // 1. 엔티티 프로젝션 : 원하는 객체를 바로 조회할 수 있다. 조회된 에티티는 영속성 컨텍스트가 관리한다.
    // 2. 임베디드 타입 프로젝션 : 엔티티와 거의 비슷하게 사용되며, 조회 시작점이 될 수 없다. (from 절에서 사용 불가)
    //    임베디드 타입은 영속성 컨텍스트에서 관리되지 않는다.
    // 3. 스탈라 타입 프로젝션 : 숫자, 문자, 낭ㄹ짜 같은 기본 데이터 타입이다. 영속성 컨텍스트가 관리하지 않는다.
    // 4. new 명령으로 활용한 프로젝션 : 다양한 종류의 단순 값들을 DTO로 바로 조회하는 방식으로 new 패키지명.DTO명 을 쓰면 DTO로 바로 반환받을 수 있다.
    //    new 명령어를 사용한 클래스의 객체느 ㄴ엔티티가 아니므로 영속성 컨텍스트가 관리하지 않는다.


    @Autowired
    private ProjectionService projectionService;


    @DisplayName("엔티티 프로젝션 조회 테스트")
    @Test
    void testEntityProjection() {
        List<Menu> menus = projectionService.findAllMenusWithEntityProjection();

        Assertions.assertNotNull(menus);
        menus.forEach(System.out::println);
    }

    @DisplayName("임베디드 타입 프로젝션 테스트")
    @Test
    void testEmbeddedTypeProjection() {
        List<CategoryName> categoryNames = projectionService.findAllCategoriesWithEmbeddedTypeProjection();

        Assertions.assertNotNull(categoryNames);
        categoryNames.forEach(System.out::println);
    }

    @DisplayName("스칼라 타입 프로젝션")
    @Test
    void testScalarProjection() {

        List<Integer> categoryCodes = projectionService.findAllCategoriesWithScalarProjection();

        Assertions.assertNotNull(categoryCodes);
        categoryCodes.forEach(System.out::println);
    }

    @DisplayName("Object[]를 활용한 스칼라 타입 프로젝션")
    @Test
    void testScalarTypeProjectionWithObjectArray() {

        List<Object[]> categoryCodesAndNames = projectionService.findAllCategoryCodesAndNames();

        Assertions.assertNotNull(categoryCodesAndNames);
        categoryCodesAndNames.forEach(row -> {
            Arrays.stream(row).forEach(System.out::println);
        });
    }

    @DisplayName("new 명령어를 활용한 프로젝션 테스트")
    @Test
    void testNewKeywordProjection() {

        List<CategoryInfo> categories = projectionService.findAllCategoryNameWithNew();

        Assertions.assertNotNull(categories);
        categories.forEach(System.out::println);
    }

}
