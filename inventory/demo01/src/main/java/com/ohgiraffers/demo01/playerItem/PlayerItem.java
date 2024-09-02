package com.ohgiraffers.demo01.playerItem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class PlayerItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerItemId;

    private Long playerId;
    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private PurchaseMethod purchaseMethod;

    private LocalDateTime purchaseDate;


}
