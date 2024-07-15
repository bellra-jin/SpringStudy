package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {


        /**
        * DB 접속에 관한 환경 설정
        * JDBCTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 자동 커밋
        *
        * PooledDataSource : ConnectionPool 사용
        * UnPooledDataSource : ConnectionPool 미사용
        */

        Environment environment = new Environment("dev"
                , new JdbcTransactionFactory(),  // 트랜젝션 매니저의 종류 결정 (JDBC or MANAGED)
                new PooledDataSource(DRIVER, URL, USER, PASSWORD)); // ConnectionPool 사용 유무 (Pooled or UnPooled)

        Configuration configuration = new Configuration(environment);
        // 매퍼 등록
        configuration.addMapper(Mapper.class);

        /**
         * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 하위 구현 객체를 생성하기 위한 빌드 역할
         */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // true or false => connection autocommit 설정

        System.out.println(sqlSession);

        Mapper mapper = sqlSession.getMapper(Mapper.class);
        java.util.Date date = mapper.selectSysdate();

        System.out.println(date);

    }
}
