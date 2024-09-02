package com.ohgiraffers.demo01.playerItem;

import com.ohgiraffers.demo01.inventory.InventoryService;
import com.ohgiraffers.demo01.purchaseItem.PurchaseItemDto;
import com.ohgiraffers.demo01.purchaseItem.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlayerItemService {

    @Autowired
    private PlayerItemRepository playerItemRepository;

    @Autowired
    private PurchaseItemService purchaseItemService;

    @Autowired
    private InventoryService inventoryService;


    @Transactional
    public PlayerItemDto createPlayerItem(Long playerId, List<PurchaseItemDto> purchaseItems, PurchaseMethod purchaseMethod) {
        int totalPrice = purchaseItems.stream()
                .mapToInt(item -> item.getQuantity() * inventoryService.getItemPrice(item.getItemId()))
                .sum();

        PlayerItem playerItem = new PlayerItem(
                null,
                playerId,
                totalPrice,
                purchaseMethod,
                LocalDateTime.now()
        );
        PlayerItem savedPlayerItem = playerItemRepository.save(playerItem);

        for (int i = 0; i < purchaseItems.size(); i++) {
            PurchaseItemDto purchaseItemDto = purchaseItems.get(i)
                    .withPurchaseOrder(i + 1)
                    .withPlayerItemId(savedPlayerItem.getPlayerItemId());

            purchaseItemService.createPurchaseItem(purchaseItemDto);

            inventoryService.updateInventory(
                    purchaseItemDto.getItemId(),
                    playerId,
                    purchaseItemDto.getQuantity()
            );
        }

        return convertToPlayerItemDto(savedPlayerItem);
    }


    public PlayerItemDto getPlayerItemById(Long playerItemId) {
        PlayerItem playerItem = playerItemRepository.findById(playerItemId)
                .orElseThrow(() -> new RuntimeException("PlayerItem not found"));

        return convertToPlayerItemDto(playerItem);
    }

    public List<PlayerItemDto> getAllPlayerItemsByPlayerId(Long playerId) {
        List<PlayerItem> playerItems = playerItemRepository.findByPlayerId(playerId);
        return playerItems.stream()
                .map(this::convertToPlayerItemDto)
                .toList();
    }

    private PlayerItemDto convertToPlayerItemDto(PlayerItem playerItem) {
        return PlayerItemDto.builder()
                .playerItemId(playerItem.getPlayerItemId())
                .playerId(playerItem.getPlayerId())
                .totalPrice(playerItem.getTotalPrice())
                .purchaseMethod(playerItem.getPurchaseMethod())
                .purchaseDate(playerItem.getPurchaseDate())
                .build();
    }
}
