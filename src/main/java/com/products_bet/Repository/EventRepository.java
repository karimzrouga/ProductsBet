package com.products_bet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products_bet.MODEL.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
