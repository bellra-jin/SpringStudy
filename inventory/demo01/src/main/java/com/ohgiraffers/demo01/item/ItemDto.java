package com.ohgiraffers.demo01.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long itemId;
    private String name;
    private ItemType itemType;
    private String description;
    private int price;
}
