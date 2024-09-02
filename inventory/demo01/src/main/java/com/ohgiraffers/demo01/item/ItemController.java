package com.ohgiraffers.demo01.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    // 아이템 생성(Create)
    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto createdItemDto = itemService.createItem(itemDto);
        return ResponseEntity.ok(createdItemDto);
    }

    // 특정 아이템 조회(Read)
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long itemId) {
        ItemDto itemDto = itemService.getItemById(itemId);
        return ResponseEntity.ok(itemDto);
    }

    // 모든 아이템 조회(Read)
    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    // 아이템 업데이트(Update)
    @PutMapping("/update/{itemId}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long itemId, @RequestBody ItemDto itemDto) {
        ItemDto updatedItemDto = itemService.updateItem(itemId, itemDto);
        return ResponseEntity.ok(updatedItemDto);
    }

    // 아이템 삭제(Delete)
    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.ok().build();
    }
}
