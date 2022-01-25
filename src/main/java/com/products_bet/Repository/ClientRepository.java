package com.products_bet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products_bet.MODEL.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByUsername(String username);
}
