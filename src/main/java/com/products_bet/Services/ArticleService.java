package com.products_bet.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Article;
import com.products_bet.Repository.ArticleRepository;

@Service
public class ArticleService extends Abstarctservices<Article> {
	@Autowired
	private ArticleRepository Cr;

	@Override
	public Iterable<Article> findAll() {

		return Cr.findAll();
	}

	@Override
	public Optional<Article> findbyid(int id) {
		// TODO Auto-generated method stub
		return Cr.findById(id);
	}

	@Override
	public void Delete(int id) {
		Cr.deleteById(id);
	}

	@Override
	public Article update(Article Article) {
		// TODO Auto-generated method stub
		return Cr.save(Article);
	}

	@Override
	public Article create(Article Article) {

		return Cr.save(Article);
	}

}
