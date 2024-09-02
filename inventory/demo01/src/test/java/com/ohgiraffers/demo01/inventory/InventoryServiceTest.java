package com.ohgiraffers.demo01.inventory;

import com.ohgiraffers.demo01.item.Item;
import com.ohgiraffers.demo01.item.ItemRepository;
import com.ohgiraffers.demo01.item.ItemType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void afterEach() {
        inventoryRepository.deleteAll(); // 테스트 후 데이터 정리
        itemRepository.deleteAll(); // 아이템 데이터 정리
    }

    @Test
    void testUpdateInventoryNewItem() {
        Long itemId = 1L;
        Long playerId = 1L;
        int quantity = 10;

        // 아이템 데이터 생성
        Item item = new Item(itemId, "Sword", ItemType.weapon, "A sharp blade", 100);
        itemRepository.save(item);

        // 인벤토리 업데이트
        inventoryService.updateInventory(itemId, playerId, quantity);

        // 업데이트된 인벤토리 검증
        Optional<Inventory> inventoryOpt = inventoryRepository.findByPlayerIdAndItemId(playerId, itemId);
        Assertions.assertTrue(inventoryOpt.isPresent());
        Inventory inventory = inventoryOpt.get();
        Assertions.assertEquals(quantity, inventory.getQuantity());
    }

    @Test
    void testUpdateInventoryExistingItem() {
        Long itemId = 1L;
        Long playerId = 1L;
        int initialQuantity = 10;

        // 아이템 및 초기 인벤토리 데이터 생성
        Item item = new Item(itemId, "Sword", ItemType.weapon, "A sharp blade", 100);
        itemRepository.save(item);

        Inventory inventory = new Inventory(null, itemId, playerId, initialQuantity);
        inventoryRepository.save(inventory);

        // 인벤토리 업데이트
        int additionalQuantity = 5;
        inventoryService.updateInventory(itemId, playerId, additionalQuantity);

        // 업데이트된 인벤토리 검증
        Optional<Inventory> updatedInventoryOpt = inventoryRepository.findByPlayerIdAndItemId(playerId, itemId);
        Assertions.assertTrue(updatedInventoryOpt.isPresent());
        Inventory updatedInventory = updatedInventoryOpt.get();
        Assertions.assertEquals(initialQuantity + additionalQuantity, updatedInventory.getQuantity());
    }

    @Test
    void testGetItemPrice() {
        Long itemId = 1L;
        int price = 100;

        // 아이템 데이터 생성
        Item item = new Item(itemId, "Sword", ItemType.weapon, "A sharp blade", price);
        itemRepository.save(item);

        // 아이템 가격 조회 및 검증
        int retrievedPrice = inventoryService.getItemPrice(itemId);
        Assertions.assertEquals(price, retrievedPrice);
    }

    @Test
    void testGetInventoryByPlayerId() {
        Long playerId = 1L;

        // 아이템 및 인벤토리 데이터 생성
        Item item1 = new Item(1L, "Sword", ItemType.weapon, "A sharp blade", 100);
        Item item2 = new Item(2L, "Shield", ItemType.armor, "A strong shield", 150);
        itemRepository.save(item1);
        itemRepository.save(item2);

        Inventory inventory1 = new Inventory(null, item1.getItemId(), playerId, 10);
        Inventory inventory2 = new Inventory(null, item2.getItemId(), playerId, 5);
        inventoryRepository.save(inventory1);
        inventoryRepository.save(inventory2);

        // 특정 플레이어의 인벤토리 조회 및 검증
        List<InventoryDto> inventoryDtos = inventoryService.getInventoryByPlayerId(playerId);
        Assertions.assertEquals(2, inventoryDtos.size());
    }

}
