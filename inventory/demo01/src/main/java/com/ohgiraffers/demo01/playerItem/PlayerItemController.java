package com.ohgiraffers.demo01.playerItem;

import com.ohgiraffers.demo01.purchaseItem.PurchaseItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player-items")
public class PlayerItemController {

    @Autowired
    private PlayerItemService playerItemService;

    // 플레이어의 아이템 구매(Create)
    @PostMapping("/purchase")
    public ResponseEntity<PlayerItemDto> createPlayerItem(
            @RequestParam Long playerId,
            @RequestBody List<PurchaseItemDto> purchaseItems,
            @RequestParam PurchaseMethod purchaseMethod) {

        PlayerItemDto playerItemDto = playerItemService.createPlayerItem(playerId, purchaseItems, purchaseMethod);
        return ResponseEntity.ok(playerItemDto);
    }

    // 특정 PlayerItem 조회(Read)
    @GetMapping("/{playerItemId}")
    public ResponseEntity<PlayerItemDto> getPlayerItemById(@PathVariable Long playerItemId) {
        PlayerItemDto playerItemDto = playerItemService.getPlayerItemById(playerItemId);
        return ResponseEntity.ok(playerItemDto);
    }

    // 플레이어의 모든 PlayerItem 조회(Read)
    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<PlayerItemDto>> getAllPlayerItemsByPlayerId(@PathVariable Long playerId) {
        List<PlayerItemDto> playerItems = playerItemService.getAllPlayerItemsByPlayerId(playerId);
        return ResponseEntity.ok(playerItems);
    }
}
