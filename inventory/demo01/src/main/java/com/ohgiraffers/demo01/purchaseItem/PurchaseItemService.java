package com.ohgiraffers.demo01.purchaseItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseItemService {

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    public PurchaseItemDto createPurchaseItem(PurchaseItemDto purchaseItemDto) {
        PurchaseItem purchaseItem = new PurchaseItem(
                null,
                purchaseItemDto.getPurchaseOrder(),
                purchaseItemDto.getPlayerItemId(), // playerItemId를 직접 사용
                purchaseItemDto.getItemId(),
                purchaseItemDto.getQuantity()
        );
        PurchaseItem savedPurchaseItem = purchaseItemRepository.save(purchaseItem);
        return convertToPurchaseItemDto(savedPurchaseItem);
    }

    public PurchaseItemDto getPurchaseItemById(Long purchaseItemId) {
        PurchaseItem purchaseItem = purchaseItemRepository.findById(purchaseItemId)
                .orElseThrow(() -> new RuntimeException("PurchaseItem not found"));

        return convertToPurchaseItemDto(purchaseItem);
    }

    public List<PurchaseItemDto> getAllPurchaseItemsByPlayerItemId(Long playerItemId) {
        List<PurchaseItem> purchaseItems = purchaseItemRepository.findByPlayerItemId(playerItemId);
        return purchaseItems.stream()
                .map(this::convertToPurchaseItemDto)
                .toList();
    }

    private PurchaseItemDto convertToPurchaseItemDto(PurchaseItem purchaseItem) {
        return PurchaseItemDto.builder()
                .purchaseItemId(purchaseItem.getPurchaseItemId())
                .purchaseOrder(purchaseItem.getPurchaseOrder())
                .playerItemId(purchaseItem.getPlayerItemId())
                .itemId(purchaseItem.getItemId())
                .quantity(purchaseItem.getQuantity())
                .build();
    }
}
