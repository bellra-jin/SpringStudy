package com.bellrajin.common;

public abstract class Product {

    private String name;
    private int price;

    public Product() {}

    public Product(String naeme, int price) {
        this.name = naeme;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String naeme) {
        this.name = naeme;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }

}
