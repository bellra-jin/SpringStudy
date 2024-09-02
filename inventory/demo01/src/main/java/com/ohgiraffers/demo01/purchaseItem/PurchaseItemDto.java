package com.ohgiraffers.demo01.purchaseItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseItemDto {
    private Long purchaseItemId;
    private int purchaseOrder;
    private Long playerItemId;
    private Long itemId;
    private int quantity;

    // with 스타일 메서드 추가
    public PurchaseItemDto withPurchaseOrder(int purchaseOrder) {
        return PurchaseItemDto.builder()
                .purchaseItemId(this.purchaseItemId)
                .purchaseOrder(purchaseOrder)
                .itemId(this.itemId)
                .quantity(this.quantity)
                .build();
    }

    public PurchaseItemDto withPlayerItemId(Long playerItemId) {
        // playerItemId가 이 DTO에 포함되어 있지 않다면, 이 메서드가 필요 없을 수 있습니다.
        return PurchaseItemDto.builder()
                .purchaseItemId(playerItemId)
                .purchaseOrder(this.purchaseOrder)
                .itemId(this.itemId)
                .quantity(this.quantity)
                .build();
    }
}
