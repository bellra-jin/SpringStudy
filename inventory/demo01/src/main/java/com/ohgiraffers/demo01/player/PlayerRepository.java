package com.ohgiraffers.demo01.player;

import com.ohgiraffers.demo01.playerItem.PlayerItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<PlayerItem> findByPlayerId(Long playerId);
}
