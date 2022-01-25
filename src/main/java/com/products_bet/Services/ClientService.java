package com.products_bet.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Client;
import com.products_bet.Repository.ClientRepository;

@Service
public class ClientService extends Abstarctservices<Client> {
	@Autowired
	private ClientRepository Cr;

	public Client findBylogin(String username) {
		return this.Cr.findByUsername(username);
	}

	@Override
	public Iterable<Client> findAll() {

		return Cr.findAll();
	}

	@Override
	public Optional<Client> findbyid(int id) {
		// TODO Auto-generated method stub
		return Cr.findById(id);
	}

	@Override
	public void Delete(int id) {
		Cr.deleteById(id);
	}

	@Override
	public Client update(Client client) {
		// TODO Auto-generated method stub
		return Cr.save(client);
	}

	@Override
	public Client create(Client client) {

		return Cr.save(client);
	}

}
