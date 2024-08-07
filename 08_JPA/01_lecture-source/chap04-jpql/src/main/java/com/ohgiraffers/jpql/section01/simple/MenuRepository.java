package com.ohgiraffers.jpql.section01.simple;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepository {

    @PersistenceContext
    private EntityManager manager;


    public String findMenuNameByMenuCode(int menuCode) {

        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = :menuCode";
        TypedQuery<String> query = manager.createQuery(jpql, String.class);
        query.setParameter("menuCode", menuCode);

        return query.getSingleResult();
    }


    public Object findObjectByMenuCode(int menuCode) {
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = :menuCode";
        Query query = manager.createQuery(jpql);
        query.setParameter("menuCode", menuCode);
        return query.getSingleResult();
    }

    public List<Menu> findAllMenusWithTypedQuery() {

        String jpql = "SELECT m FROM Section01Menu as m";
        TypedQuery<Menu> query = manager.createQuery(jpql, Menu.class);

        return query.getResultList();
    }
}
