package com.ohgiraffers.persistence.section02.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ohgiraffers");

    private EntityManagerGenerator() {
    }

    public static EntityManager getMangerInstance() {

        return entityManagerFactory.createEntityManager();
    }
}