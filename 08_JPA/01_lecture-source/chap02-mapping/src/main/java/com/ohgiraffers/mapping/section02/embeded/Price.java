package com.ohgiraffers.mapping.section02.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
// 의미있는 단어를 묶어 놓은 클래스

// 어딘가 사용될 수 있는 의미의 어노테이션
@Embeddable
public class Price {

    @Column(name="REGULAR_PRICE")
    private int regularPrice;

    @Column(name="DISCOUNT_RATE")
    private double discountRate;

    @Column(name="SELL_PRICE")
    private int sellPrice;

    protected Price() {}

    public Price(int regularPrice, double discountRate) {
        // regularPrice, discountRate가 음수인지 확인하는 로직
        validateNegativePrice(regularPrice);
        validateNegativeDiscountRate(discountRate);

        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
        this.sellPrice = calcSellPrice(regularPrice, discountRate);
    }

    private void validateNegativePrice(int regularPrice) {
        if(regularPrice < 0) {
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }
    }

    private void validateNegativeDiscountRate(double discountRate) {
        if(discountRate < 0) {
            throw new IllegalArgumentException("할인율은 음수일 수 없습니다.");
        }
    }

    private int calcSellPrice(int regularPrice, double discountRate) {

        return (int) (regularPrice - (regularPrice * discountRate));
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "regularPrice=" + regularPrice +
                ", discountRate=" + discountRate +
                ", sellPrice=" + sellPrice +
                '}';
    }
}
