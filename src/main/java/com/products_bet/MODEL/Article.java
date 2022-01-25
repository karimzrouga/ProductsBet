package com.products_bet.MODEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Article")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdArticle;
	private String name;
	private String image;
	private String description;
	@ManyToOne
	@JoinColumn(name = "IdCategorie", nullable = false)
	@JsonIgnore
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name = "IdBet", nullable = true)
	@JsonIgnore
	private  Bet bet;

	
	
	
}
