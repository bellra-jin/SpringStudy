package com.ohgiraffers.demo01.playerItem;

import com.ohgiraffers.demo01.inventory.InventoryDto;
import com.ohgiraffers.demo01.inventory.InventoryService;
import com.ohgiraffers.demo01.item.ItemDto;
import com.ohgiraffers.demo01.item.ItemService;
import com.ohgiraffers.demo01.item.ItemType;
import com.ohgiraffers.demo01.player.Player;
import com.ohgiraffers.demo01.player.PlayerService;
import com.ohgiraffers.demo01.purchaseItem.PurchaseItemDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerItemServiceTest {

    @Autowired
    private PlayerItemService playerItemService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PlayerService playerService;

    @AfterEach
    void afterEach() {
        // 각 서비스의 리포지토리를 클리어하는 로직
        // 예: playerRepository.deleteAll(), itemRepository.deleteAll(), 등
    }

    @Test
    void testPlayerItemPurchase() {
        // 1. 플레이어 생성
        Player player = new Player(null, "John Doe");
        Player savedPlayer = playerService.createPlayer(player);

        // 2. 아이템 생성
        ItemDto itemDto = ItemDto.builder()
                .name("Sword")
                .itemType(ItemType.weapon)
                .description("A sharp blade")
                .price(100)
                .build();
        ItemDto createdItem = itemService.createItem(itemDto);

        // 3. 아이템 구매
        PurchaseItemDto purchaseItemDto = PurchaseItemDto.builder()
                .itemId(createdItem.getItemId())
                .quantity(1)
                .build();

        PlayerItemDto playerItemDto = playerItemService.createPlayerItem(
                savedPlayer.getPlayerId(),
                Arrays.asList(purchaseItemDto),
                PurchaseMethod.CREDIT_CARD
        );

        assertNotNull(playerItemDto);
        assertEquals(100, playerItemDto.getTotalPrice());

        // 4. 인벤토리 업데이트 확인
        InventoryDto inventoryDto = inventoryService.getInventoryByPlayerId(savedPlayer.getPlayerId()).get(0);
        assertEquals(1, inventoryDto.getQuantity());
        assertEquals(createdItem.getItemId(), inventoryDto.getItemId());
    }

    @Test
    void testPurchaseWithInvalidPlayer() {
        Long invalidPlayerId = 999L; // 존재하지 않는 ID

        PurchaseItemDto purchaseItemDto = PurchaseItemDto.builder()
                .itemId(1L)
                .quantity(1)
                .build();

        assertThrows(RuntimeException.class, () -> {
            playerItemService.createPlayerItem(
                    invalidPlayerId,
                    Arrays.asList(purchaseItemDto),
                    PurchaseMethod.CREDIT_CARD
            );
        });
    }
}
