package com.products_bet.Config;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AuthentificationRequest {
	private String username;
	private String password;

}
