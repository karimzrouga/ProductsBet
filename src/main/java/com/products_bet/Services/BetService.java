package com.products_bet.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Bet;
import com.products_bet.Repository.BetRepository;

@Service
public class BetService extends Abstarctservices<Bet> {
	@Autowired
	private BetRepository Cr;

	@Override
	public Iterable<Bet> findAll() {

		return Cr.findAll();
	}

	@Override
	public Optional<Bet> findbyid(int id) {
		// TODO Auto-generated method stub
		return Cr.findById(id);
	}

	@Override
	public void Delete(int id) {
		Cr.deleteById(id);
	}

	@Override
	public Bet update(Bet Bet) {
		// TODO Auto-generated method stub
		return Cr.save(Bet);
	}

	@Override
	public Bet create(Bet Bet) {

		return Cr.save(Bet);
	}

}
