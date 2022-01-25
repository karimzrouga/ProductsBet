package com.products_bet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products_bet.MODEL.Bet;

public interface BetRepository extends JpaRepository<Bet, Integer> {

}
