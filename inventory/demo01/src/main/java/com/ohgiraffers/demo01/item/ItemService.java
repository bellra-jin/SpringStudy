package com.ohgiraffers.demo01.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    // 아이템 생성(Create)
    public ItemDto createItem(ItemDto itemDto) {
        Item item = new Item(
                null,
                itemDto.getName(),
                itemDto.getItemType(),
                itemDto.getDescription(),
                itemDto.getPrice()
        );
        Item savedItem = itemRepository.save(item);
        return convertToDto(savedItem);
    }

    // 아이템 조회(Read) - ID로 조회
    public ItemDto getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        return convertToDto(item);
    }

    // 모든 아이템 조회(Read) - 모든 아이템 리스트 가져오기
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(this::convertToDto)
                .toList();
    }

    // 아이템 업데이트(Update)
    public ItemDto updateItem(Long itemId, ItemDto itemDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item = new Item(
                item.getItemId(),
                itemDto.getName(),
                itemDto.getItemType(),
                itemDto.getDescription(),
                itemDto.getPrice()
        );

        Item updatedItem = itemRepository.save(item);
        return convertToDto(updatedItem);
    }

    // 아이템 삭제(Delete)
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        itemRepository.delete(item);
    }

    // Item 엔티티를 ItemDto로 변환하는 메서드
    public ItemDto convertToDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getItemId())
                .name(item.getName())
                .itemType(item.getItemType())
                .description(item.getDescription())
                .price(item.getPrice())
                .build();
    }
}
