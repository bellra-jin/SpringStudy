package com.ohgiraffers.demo01.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByPlayerId(Long playerId);
    Optional<Inventory> findByPlayerIdAndItemId(Long playerId, Long itemId);
}
