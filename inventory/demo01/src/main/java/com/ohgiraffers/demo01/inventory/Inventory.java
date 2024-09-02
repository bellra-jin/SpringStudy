package com.ohgiraffers.demo01.inventory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private Long itemId;
    private Long playerId;
    private int quantity;

    public Inventory updateQuantity(int quantity) {
        return new Inventory(this.inventoryId, this.itemId, this.playerId, quantity);
    }
}
