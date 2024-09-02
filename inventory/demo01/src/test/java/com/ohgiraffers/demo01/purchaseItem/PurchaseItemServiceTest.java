package com.ohgiraffers.demo01.purchaseItem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PurchaseItemServiceTest {

    @Autowired
    private PurchaseItemService purchaseItemService;

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @AfterEach
    void afterEach() {
        purchaseItemRepository.deleteAll(); // 테스트 후 데이터 정리
    }

    @Test
    void testCreatePurchaseItem() {
        PurchaseItemDto purchaseItemDto = PurchaseItemDto.builder()
                .purchaseOrder(1)
                .playerItemId(1L)
                .itemId(1L)
                .quantity(5)
                .build();

        PurchaseItemDto createdPurchaseItem = purchaseItemService.createPurchaseItem(purchaseItemDto);

        Assertions.assertNotNull(createdPurchaseItem);
        Assertions.assertNotNull(createdPurchaseItem.getPurchaseItemId());
        Assertions.assertEquals(1, createdPurchaseItem.getPurchaseOrder());
        Assertions.assertEquals(1L, createdPurchaseItem.getPlayerItemId());
        Assertions.assertEquals(1L, createdPurchaseItem.getItemId());
        Assertions.assertEquals(5, createdPurchaseItem.getQuantity());
    }

    @Test
    void testGetPurchaseItemById() {
        PurchaseItemDto purchaseItemDto = PurchaseItemDto.builder()
                .purchaseOrder(1)
                .playerItemId(1L)
                .itemId(1L)
                .quantity(5)
                .build();

        PurchaseItemDto createdPurchaseItem = purchaseItemService.createPurchaseItem(purchaseItemDto);

        PurchaseItemDto foundPurchaseItem = purchaseItemService.getPurchaseItemById(createdPurchaseItem.getPurchaseItemId());
        Assertions.assertNotNull(foundPurchaseItem);
        Assertions.assertEquals(createdPurchaseItem.getPurchaseItemId(), foundPurchaseItem.getPurchaseItemId());
        Assertions.assertEquals(1, foundPurchaseItem.getPurchaseOrder());
        Assertions.assertEquals(1L, foundPurchaseItem.getPlayerItemId());
        Assertions.assertEquals(1L, foundPurchaseItem.getItemId());
        Assertions.assertEquals(5, foundPurchaseItem.getQuantity());
    }

    @Test
    void testGetAllPurchaseItemsByPlayerItemId() {
        PurchaseItemDto purchaseItemDto1 = PurchaseItemDto.builder()
                .purchaseOrder(1)
                .playerItemId(1L)
                .itemId(1L)
                .quantity(5)
                .build();

        PurchaseItemDto purchaseItemDto2 = PurchaseItemDto.builder()
                .purchaseOrder(2)
                .playerItemId(1L)
                .itemId(2L)
                .quantity(3)
                .build();

        purchaseItemService.createPurchaseItem(purchaseItemDto1);
        purchaseItemService.createPurchaseItem(purchaseItemDto2);

        List<PurchaseItemDto> purchaseItems = purchaseItemService.getAllPurchaseItemsByPlayerItemId(1L);

        Assertions.assertEquals(2, purchaseItems.size());
    }
}