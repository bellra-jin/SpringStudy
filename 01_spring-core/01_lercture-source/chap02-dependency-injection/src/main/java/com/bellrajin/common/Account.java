package com.bellrajin.common;

public interface Account {

    String getBalance();

    String deposit(int money);

    String withdraw(int money);
}
