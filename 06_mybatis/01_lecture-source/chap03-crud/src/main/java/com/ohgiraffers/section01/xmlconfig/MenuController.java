package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class MenuController {

    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();

        if(menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("findAll");
        }
    }
}
