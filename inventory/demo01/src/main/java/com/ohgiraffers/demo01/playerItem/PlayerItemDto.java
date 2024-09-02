package com.ohgiraffers.demo01.playerItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerItemDto {
    private Long playerItemId;
    private Long playerId;
    private int totalPrice;
    private PurchaseMethod purchaseMethod;
    private LocalDateTime purchaseDate;


}
