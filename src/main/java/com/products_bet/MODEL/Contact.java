package com.products_bet.MODEL;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Contact")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idc;
	private String fullname;
	private String email;
	private String CT;
	private String message;
	private String phone;
	private String Inquiretype;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

}
