package com.ohgiraffers.demo01.purchaseItem;

import com.ohgiraffers.demo01.playerItem.PlayerItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseItemId;  // 아이템 구매번호 (고유 ID)
    private int purchaseOrder;    // 구매순번
    private Long playerItemId;
    private Long itemId;           // 아이템 번호
    private int quantity;         // 구매수량

}
