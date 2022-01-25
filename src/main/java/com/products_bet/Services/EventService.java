package com.products_bet.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Event;
import com.products_bet.Repository.EventRepository;

@Service
public class EventService extends Abstarctservices<Event> {
	@Autowired
	private EventRepository Cr;

	@Override
	public Iterable<Event> findAll() {

		return Cr.findAll();
	}

	@Override
	public Optional<Event> findbyid(int id) {
		// TODO Auto-generated method stub
		return Cr.findById(id);
	}

	@Override
	public void Delete(int id) {
		Cr.deleteById(id);
	}

	@Override
	public Event update(Event Event) {
		// TODO Auto-generated method stub
		return Cr.save(Event);
	}

	@Override
	public Event create(Event Event) {

		return Cr.save(Event);
	}

}
