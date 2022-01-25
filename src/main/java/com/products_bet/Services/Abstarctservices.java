package com.products_bet.Services;

import java.util.Optional;



public abstract class Abstarctservices <t> {
	public abstract  Iterable<t> findAll() ;
	public abstract Optional<t> findbyid(int id) ;
	public abstract  void Delete (int id);
	public abstract t update(t a) ;
	public abstract t create(t a) ;
	
}