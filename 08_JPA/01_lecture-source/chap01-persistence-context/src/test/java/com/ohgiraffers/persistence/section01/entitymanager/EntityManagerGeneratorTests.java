package com.ohgiraffers.persistence.section01.entitymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerGeneratorTests {

    // 엔티티 메니저란?
    // 엔티티를 저장하는 메모리상의 데이터베이스라고 생각하면 된다.
    // 엔티티를 저장하고 수정하고 삭제하고 조회하는 드으이 엔티티와 관련된 모든 일을 한다.
    // 엔티티 메니저는 스레드 세이프하지 않기 때문에 동시성 문제가 밸생할 수 있기 때문에
    // 스레드간 공유르 ㄹ하면 안된다. (web의 경우 request scope와 일치시킨다.)


    // 영속성 컨텍스트(Persistence Context)란?
    // 영속성 컨텍스는 엔티티를 영구 저장하는 환경을 말한다.
    // 엔티티 매니저에 엔티티르 렂장하거나 조회하면 엔티티 매니저는 영속성 컨텕스트에 엔티티를 보관하고 관리한다.
    // 영속성 엔티티를 key value 방식으로 젖아하는 저장소 역할을 한다.
    // 영속성 컨텍스트는 엔티티 매니저를 생성할 때 하나 만들어진다.
    // 엔티티 매니저를 통해서 영속성 컨텍스트에 접근할 수 있고 영속성 컨텍스트를 관리할 수 있다.


    // 앤티티 매니저 팩토리 (EntityManagerFactory)란?
    // 엔티티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클랙스이다.
    // 스레드 세이프이기 때문에 여러 스레드가 동시에ㅐ 접근해도 안전하기 때문에
    // 서로 다른 스레드간 공유해서 재사용한다.
    // 하지마 스레드 세이프한 기능을 요청 스코프마다 생성하기에는 비용(시간, 메모리)부담이 크기 떄문에
    // application 스코프와 동일한 싱글톤으로 생성해서 관리하게 된다.
    // 따라서 데이터베이스를 사용하는 애플리케이션 당 한 개의 EntityManagerFactory를 생성한다.


    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    @Test
    void testGenerateEntityManagerFactory() {

        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();

        Assertions.assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    void testIsEntityManagerFactorySingletonInstance() {

        //given
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();


        //when
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();


        //then
        Assertions.assertEquals(factory1, factory2);
    }


    @Test
    @DisplayName("엔티티 매니저 생성 확인")
    void testGenerateEntityManager() {

        EntityManager manager = EntityManagerGernerator.getInstance();

        Assertions.assertNotNull(manager);
    }


    @Test
    @DisplayName("엔티티 매니저 생명주기 확인")
    void testEntityMangerLifeCycle() {

        EntityManager manager1 = EntityManagerGernerator.getInstance();
        EntityManager manager2 = EntityManagerGernerator.getInstance();

        Assertions.assertNotEquals(manager1, manager2);
    }
}
