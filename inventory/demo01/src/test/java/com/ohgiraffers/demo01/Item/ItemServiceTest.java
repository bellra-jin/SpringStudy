package com.ohgiraffers.demo01.Item;

import com.ohgiraffers.demo01.item.ItemDto;
import com.ohgiraffers.demo01.item.ItemRepository;
import com.ohgiraffers.demo01.item.ItemService;
import com.ohgiraffers.demo01.item.ItemType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void afterEach() {
        itemRepository.deleteAll(); // 테스트 후 데이터 정리
    }

    @Test
    void testCreateAndGetItem() {
        ItemDto itemDto = ItemDto.builder()
                .name("Sword")
                .itemType(ItemType.weapon)
                .description("A sharp blade")
                .price(100)
                .build();

        ItemDto createdItem = itemService.createItem(itemDto);
        assertNotNull(createdItem);
        assertEquals("Sword", createdItem.getName());

        ItemDto foundItem = itemService.getItemById(createdItem.getItemId());
        assertNotNull(foundItem);
        assertEquals("Sword", foundItem.getName());
    }

    @Test
    void testUpdateItem() {
        ItemDto itemDto = ItemDto.builder()
                .name("Sword")
                .itemType(ItemType.weapon)
                .description("A sharp blade")
                .price(100)
                .build();

        ItemDto createdItem = itemService.createItem(itemDto);

        ItemDto updateDto = ItemDto.builder()
                .name("Updated Sword")
                .itemType(ItemType.weapon)
                .description("An even sharper blade")
                .price(150)
                .build();

        ItemDto updatedItem = itemService.updateItem(createdItem.getItemId(), updateDto);
        assertEquals("Updated Sword", updatedItem.getName());
        assertEquals(150, updatedItem.getPrice());
    }

    @Test
    void testDeleteItem() {
        ItemDto itemDto = ItemDto.builder()
                .name("Sword")
                .itemType(ItemType.weapon)
                .description("A sharp blade")
                .price(100)
                .build();

        ItemDto createdItem = itemService.createItem(itemDto);
        itemService.deleteItem(createdItem.getItemId());

        assertThrows(RuntimeException.class, () -> itemService.getItemById(createdItem.getItemId()));
    }
}
