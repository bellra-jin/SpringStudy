package com.ohgiraffers.mybatistest.model.dao;

import com.ohgiraffers.mybatistest.model.dto.CategoryDTO;
import com.ohgiraffers.mybatistest.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> findAllMenu();

    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO menuNew);
}
