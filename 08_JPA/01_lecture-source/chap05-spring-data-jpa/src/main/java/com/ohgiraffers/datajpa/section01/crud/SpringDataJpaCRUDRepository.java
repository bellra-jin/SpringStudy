package com.ohgiraffers.datajpa.section01.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaCRUDRepository extends JpaRepository<Menu, Integer> {


}
