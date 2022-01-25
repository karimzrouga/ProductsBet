package com.products_bet.MODEL;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Bet")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdBet;
	private String name;
	private Double initialprix;
	private Double finalprix;
	private String image;
	private String description;
	private Date lastdate;
	private boolean State;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listbets")
	private List<Client> ListClients = new ArrayList<Client>();
	@OneToMany(mappedBy = "bet")
	private List<Article> ListArticle = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEvent", nullable = true)
	@JsonIgnore
	private Event event;

	public void addclient(Client c) {
		ListClients.add(c);
	}

	public void addarticle(Article article) {
		ListArticle.add(article);		
	}

	
}
