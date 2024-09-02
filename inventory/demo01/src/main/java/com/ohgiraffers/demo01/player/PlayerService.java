package com.ohgiraffers.demo01.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // 플레이어 등록(Create)
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // 플레이어 조회(Read) - ID로 조회
    public Optional<Player> getPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }

    // 모든 플레이어 조회(Read) - 모든 플레이어 리스트 가져오기
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // 플레이어 정보 업데이트(Update)
    public Player updatePlayer(Long playerId, PlayerDto playerDto) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        // 필요한 필드를 업데이트하는 메서드 호출
        player.updateName(playerDto.getName());

        return playerRepository.save(player);
    }

    // 플레이어 삭제(Delete)
    public void deletePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        playerRepository.delete(player);
    }
}
