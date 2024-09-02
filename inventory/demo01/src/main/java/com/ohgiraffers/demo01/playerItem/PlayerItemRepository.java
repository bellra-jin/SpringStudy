package com.ohgiraffers.demo01.playerItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerItemRepository extends JpaRepository<PlayerItem, Long> {

    List<PlayerItem> findByPlayerId(Long playerId);
}
