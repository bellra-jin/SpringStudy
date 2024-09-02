package com.ohgiraffers.demo01.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    final private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    // 플레이어 생성
    @PostMapping("/create")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // 특정 플레이어 조회
    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        return playerService.getPlayerById(playerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 모든 플레이어 조회
    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // 플레이어 업데이트
    @PutMapping("/update/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @RequestBody PlayerDto playerDto) {
        Player updatedPlayer = playerService.updatePlayer(playerId, playerDto);
        return ResponseEntity.ok(updatedPlayer);
    }

    // 플레이어 삭제
    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.ok().build();
    }
}
