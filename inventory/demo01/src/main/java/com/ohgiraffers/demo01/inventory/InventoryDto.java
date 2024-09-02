package com.ohgiraffers.demo01.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto {
    private Long inventoryId;
    private Long itemId;
    private Long playerId;
    private int quantity;
}
