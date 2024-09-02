package com.ohgiraffers.demo01.inventory;

import com.ohgiraffers.demo01.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemRepository itemRepository; // 아이템 가격을 가져오기 위해 사용

    public void updateInventory(Long itemId, Long playerId, int quantity) {
        Optional<Inventory> inventoryOpt = inventoryRepository.findByPlayerIdAndItemId(playerId, itemId);

        Inventory inventory;
        if (inventoryOpt.isPresent()) {
            inventory = inventoryOpt.get().updateQuantity(inventoryOpt.get().getQuantity() + quantity);
        } else {
            inventory = new Inventory(null, itemId, playerId, quantity);
        }

        inventoryRepository.save(inventory);
    }

    public int getItemPrice(Long itemId) {
        return itemRepository.findById(itemId)
                .map(item -> item.getPrice())  // Item::getPrice 대신 람다 표현식 사용
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    // 새로운 메서드: 특정 플레이어의 인벤토리 조회
    public List<InventoryDto> getInventoryByPlayerId(Long playerId) {
        List<Inventory> inventoryList = inventoryRepository.findByPlayerId(playerId);
        return inventoryList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Inventory 엔티티를 InventoryDto로 변환하는 메서드
    private InventoryDto convertToDto(Inventory inventory) {
        return InventoryDto.builder()
                .inventoryId(inventory.getInventoryId())
                .itemId(inventory.getItemId())
                .playerId(inventory.getPlayerId())
                .quantity(inventory.getQuantity())
                .build();
    }
}
