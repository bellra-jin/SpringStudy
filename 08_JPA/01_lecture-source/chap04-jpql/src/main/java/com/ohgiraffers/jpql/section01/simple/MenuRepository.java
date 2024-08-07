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

    public List<Menu> findAllMenusWithQuery() {

        String jpql = "SELECT m FROM Section01Menu as m";
        Query query = manager.createQuery(jpql);

        return query.getResultList();
    }

    public List<Integer> findAllCategoryCodeInMenu() {
        String jpql = "select distinct m.categoryCode from Section01Menu as m";
        TypedQuery<Integer> query = manager.createQuery(jpql, Integer.class);
        return query.getResultList();
    }

    public List<Menu> findMenusInCategoryCodes(List<Integer> categoryCodes) {

        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT m FROM Section01Menu m WHERE m.categoryCode in(");
        int categoryCodeSize = categoryCodes.size();
        for (int i = 0; i < categoryCodeSize; i++) {
            jpql.append(categoryCodes.get(i));
            if(i != categoryCodeSize -1) {
                jpql.append(",");
            }
        }
        jpql.append(")");

        TypedQuery<Menu> query = manager.createQuery(jpql.toString(), Menu.class);
        return query.getResultList();
    }

    public List<Menu> searchMenuBySearchValue(String searchValue) {

        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuName LIKE CONCAT('%', :searchValue, '%')";

        return manager.createQuery(jpql, Menu.class)
                .setParameter("searchValue", searchValue)
                .getResultList();

    }
}
