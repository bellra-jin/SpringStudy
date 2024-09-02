package com.ohgiraffers.demo01.purchaseItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-items")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemService purchaseItemService;

    @PostMapping("/create")
    public ResponseEntity<PurchaseItemDto> createPurchaseItem(@RequestBody PurchaseItemDto purchaseItemDto) {
        PurchaseItemDto createdItem = purchaseItemService.createPurchaseItem(purchaseItemDto);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/{purchaseItemId}")
    public ResponseEntity<PurchaseItemDto> getPurchaseItemById(@PathVariable Long purchaseItemId) {
        PurchaseItemDto purchaseItem = purchaseItemService.getPurchaseItemById(purchaseItemId);
        return ResponseEntity.ok(purchaseItem);
    }

    @GetMapping("/player-item/{playerItemId}")
    public ResponseEntity<List<PurchaseItemDto>> getAllPurchaseItemsByPlayerItemId(@PathVariable Long playerItemId) {
        List<PurchaseItemDto> purchaseItems = purchaseItemService.getAllPurchaseItemsByPlayerItemId(playerItemId);
        return ResponseEntity.ok(purchaseItems);
    }
}
