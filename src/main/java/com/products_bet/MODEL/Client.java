package com.products_bet.MODEL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Client")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idclient;
	private String username;
	private String fullname;
	private String password;
	private String image;
	private String Email;
	private String phone;
	private Double solde=0.0;
	private String adresse;
	private String Role;
	/*************************************************************************/
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name = "enchere", joinColumns = @JoinColumn(name = "Idclient"), inverseJoinColumns = @JoinColumn(name = "IdBet"))
	private List<Bet> listbets = new ArrayList<Bet>();

	/*******************************************/

	public void addbet(Bet b) {
		listbets.add(b);
	}

	public boolean notExsiste(Bet b) {
		boolean exit = true;
		int index = 0;
		if (this.listbets.size() > 0) {
			while (exit &&  index <this.listbets.size()-1) {
				exit = this.listbets.get(index).getIdBet() == b.getIdBet();
				index++;

			}

		}

		return exit;

	}

}
