package com.ohgiraffers.mybatistest.controller;

import com.ohgiraffers.mybatistest.model.dto.CategoryDTO;
import com.ohgiraffers.mybatistest.model.dto.MenuDTO;
import com.ohgiraffers.mybatistest.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String findMenuList(Model model) {
        List<MenuDTO> menuList = menuService.findAllMenu();
        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("/regist")
    public void registPage(){}

    @GetMapping(value="category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    public String registNewMenu(MenuDTO menuNew, RedirectAttributes rttr, Locale locale) {

        menuService.registNewMenu(menuNew);
        System.out.println("menuNew = " + menuNew);
        logger.info("logger : {} ", locale);
        rttr.addFlashAttribute("success", "menu added successfully");
        return "redirect:/menu/list";
    }


}

