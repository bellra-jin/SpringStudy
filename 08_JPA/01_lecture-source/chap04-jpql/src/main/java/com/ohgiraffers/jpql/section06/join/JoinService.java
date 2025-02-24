package com.ohgiraffers.jpql.section06.join;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinService {

    private JoinRepository joinRepository;

    @Autowired
    public JoinService(JoinRepository joinRepository) {
        this.joinRepository = joinRepository;
    }

    public List<Menu> findAllMenusUsingInnerJoin() {
        return joinRepository.findAllMenusUsingInnerJoin();
    }

    public List<Menu> findAllMenusUsingFetchJoin() {
        return joinRepository.findAllMenusUsingFetchJoin();
    }

    public List<Category> findAllMenusInCategory() {
        return joinRepository.findAllMenusInCategory();
    }
}
