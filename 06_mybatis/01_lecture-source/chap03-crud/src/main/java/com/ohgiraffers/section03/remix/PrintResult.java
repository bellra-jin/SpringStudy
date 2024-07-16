package com.ohgiraffers.section03.remix;


import java.util.List;

public class PrintResult {

    public void printMenuList(List<com.ohgiraffers.section03.remix.MenuDTO> menuList) {

        menuList.forEach(System.out::println);
    }

    public void printErrorMessage(String msg) {

        String errorMessage = "";
        switch (msg) {
            case "findAll" : errorMessage = "메뉴 목록 조회를 실패하셨습니다."; break;
            case "findOne" : errorMessage = "메뉴 상세 조회를 실패하셨습니다."; break;
            case "insert" : errorMessage = "신규 메뉴 등록에 실패하셨습니다."; break;
            case "update" : errorMessage = "메뉴 수정에 실패하셨습니다."; break;
            case "delete" : errorMessage = "메뉴 삭제에 실패하셨습니다."; break;
        }

        System.out.println(errorMessage);
    }

    public void printMenu(MenuDTO menu) {

        System.out.println(menu);
    }

    public void printSuccessMessage(String msg) {

        String SuccessMessage = "";
        switch (msg) {
            case "insert": SuccessMessage = "신규 메뉴 등록에 성공하셨습니다!"; break;
            case "update": SuccessMessage = "메뉴 수정에 성공하셨습니다!"; break;
            case "delete": SuccessMessage = "메뉴 삭제에 성공하셨습니다!"; break;
        }
        System.out.println(SuccessMessage);
    }


}
