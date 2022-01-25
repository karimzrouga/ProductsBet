package com.products_bet.MODEL;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Event")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdEvent;
	private String name;
	private String image;
	private String description;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@OneToMany(mappedBy = "event")
	private List<Bet> ListBet = new ArrayList<>();

	public void addbet(Bet b) {
		ListBet.add(b);

	}

	public boolean notExsiste(Bet b) {
		boolean exit = true;
		int index = 0;
		if (this.ListBet.size() > 0) {
			while (exit && this.ListBet.size() > 0) {
				exit = this.ListBet.get(index).getIdBet() == b.getIdBet();
				index++;

			}

		}

		return exit;

	}
}
