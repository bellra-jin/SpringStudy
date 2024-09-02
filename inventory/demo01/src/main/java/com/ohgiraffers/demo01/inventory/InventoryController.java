package com.ohgiraffers.demo01.inventory;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // 특정 플레이어의 인벤토리 조회 (Read)
    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<InventoryDto>> getInventoryByPlayerId(@PathVariable Long playerId) {
        List<InventoryDto> inventoryItems = inventoryService.getInventoryByPlayerId(playerId);
        return ResponseEntity.ok(inventoryItems);
    }

    // 특정 플레이어의 특정 아이템 인벤토리 수량 업데이트 (Update)
    @PutMapping("/update")
    public ResponseEntity<Void> updateInventory(
            @RequestParam Long itemId,
            @RequestParam Long playerId,
            @RequestParam int quantity) {
        inventoryService.updateInventory(itemId, playerId, quantity);
        return ResponseEntity.ok().build();
    }

    // 특정 아이템의 가격 조회 (Read)
    @GetMapping("/item-price/{itemId}")
    public ResponseEntity<Integer> getItemPrice(@PathVariable Long itemId) {
        int price = inventoryService.getItemPrice(itemId);
        return ResponseEntity.ok(price);
    }
}
