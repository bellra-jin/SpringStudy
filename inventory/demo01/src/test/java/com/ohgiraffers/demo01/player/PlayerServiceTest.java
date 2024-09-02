package com.ohgiraffers.demo01.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @AfterEach
    void afterEach() {
        playerRepository.deleteAll(); // 테스트 후 데이터 정리
    }

    @Test
    void testCreatePlayer() {
        Player player = new Player(null, "John Doe");
        Player createdPlayer = playerService.createPlayer(player);

        Assertions.assertNotNull(createdPlayer);
        Assertions.assertNotNull(createdPlayer.getPlayerId());
        Assertions.assertEquals("John Doe", createdPlayer.getName());
    }

    @Test
    void testGetPlayerById() {
        Player player = new Player(null, "John Doe");
        Player createdPlayer = playerService.createPlayer(player);

        Optional<Player> foundPlayer = playerService.getPlayerById(createdPlayer.getPlayerId());
        Assertions.assertTrue(foundPlayer.isPresent());
        Assertions.assertEquals("John Doe", foundPlayer.get().getName());
    }

    @Test
    void testGetAllPlayers() {
        Player player1 = new Player(null, "John Doe");
        Player player2 = new Player(null, "Jane Doe");
        playerService.createPlayer(player1);
        playerService.createPlayer(player2);

        List<Player> players = playerService.getAllPlayers();
        Assertions.assertEquals(2, players.size());
    }

    @Test
    void testUpdatePlayer() {
        Player player = new Player(null, "John Doe");
        Player createdPlayer = playerService.createPlayer(player);

        PlayerDto playerDto = PlayerDto.builder()
                .playId(createdPlayer.getPlayerId())
                .name("Updated Name")
                .build();

        Player updatedPlayer = playerService.updatePlayer(createdPlayer.getPlayerId(), playerDto);

        Assertions.assertNotNull(updatedPlayer);
        Assertions.assertEquals("Updated Name", updatedPlayer.getName());
    }

    @Test
    void testDeletePlayer() {
        Player player = new Player(null, "John Doe");
        Player createdPlayer = playerService.createPlayer(player);

        playerService.deletePlayer(createdPlayer.getPlayerId());

        Optional<Player> deletedPlayer = playerService.getPlayerById(createdPlayer.getPlayerId());
        Assertions.assertFalse(deletedPlayer.isPresent());
    }
}
