package com.products_bet.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Categorie;
import com.products_bet.Repository.CategorieRepository;

@Service
public class CategorieService extends Abstarctservices<Categorie> {
	@Autowired
	private CategorieRepository Cr;

	@Override
	public Iterable<Categorie> findAll() {

		return Cr.findAll();
	}

	@Override
	public Optional<Categorie> findbyid(int id) {
		// TODO Auto-generated method stub
		return Cr.findById(id);
	}

	@Override
	public void Delete(int id) {
		Cr.deleteById(id);
	}

	@Override
	public Categorie update(Categorie Categorie) {
		// TODO Auto-generated method stub
		return Cr.save(Categorie);
	}

	@Override
	public Categorie create(Categorie Categorie) {

		return Cr.save(Categorie);
	}

}
