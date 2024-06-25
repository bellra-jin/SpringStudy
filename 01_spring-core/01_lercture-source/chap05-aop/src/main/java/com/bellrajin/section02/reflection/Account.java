package com.bellrajin.section02.reflection;

public class Account {

    private String bankConde;
    private String accNo;
    private String accPwd;
    private int balance;

    public Account() {}

    public Account(String bankConde, String accNo, String accPwd) {
        this.bankConde = bankConde;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }

    public Account(String bankConde, String accNo, String accPwd, int balance) {
        this.bankConde = bankConde;
        this.accNo = accNo;
        this.accPwd = accPwd;
        this.balance = balance;
    }

    public String getBalance() {
        return this.accNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    public String deposit(int money) {

        String str = "";
        if (money > 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "금액을 잘못 입력하셨습니다.";
        }
        return str;
    }

    public String withdraw(int money) {
        String str = "";
        if (money > 0) {
            this.balance -= money;
            str = money + "원이 출급되었습니다.";
        } else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요";
        }
        return str;
    }

}
