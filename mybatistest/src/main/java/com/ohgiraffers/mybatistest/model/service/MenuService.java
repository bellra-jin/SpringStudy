package com.ohgiraffers.mybatistest.model.service;

import com.ohgiraffers.mybatistest.model.dao.MenuMapper;
import com.ohgiraffers.mybatistest.model.dto.CategoryDTO;
import com.ohgiraffers.mybatistest.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.beans.Transient;
import java.util.List;


@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    @Transactional
    public void registNewMenu(MenuDTO menuNew) {
        menuMapper.registNewMenu(menuNew);
    }
}
