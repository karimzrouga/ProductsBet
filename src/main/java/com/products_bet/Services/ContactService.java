package com.products_bet.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Contact;
import com.products_bet.Repository.ContactRepository;

@Service
public class ContactService extends Abstarctservices<Contact> {
	@Autowired
	private ContactRepository AR;

	@Override
	public Iterable<Contact> findAll() {

		return AR.findAll();
	}

	@Override
	public Optional<Contact> findbyid(int id) {
		// TODO Auto-generated method stub
		return AR.findById(id);
	}

	@Override
	public void Delete(int id) {
		AR.deleteById(id);
	}

	@Override
	public Contact update(Contact contact) {
		// TODO Auto-generated method stub
		return AR.save(contact);
	}

	@Override
	public Contact create(Contact contact) {
		// TODO Auto-generated method stub
		return AR.save(contact);
	}

}
