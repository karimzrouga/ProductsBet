package com.products_bet.Config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.products_bet.MODEL.Client;
import com.products_bet.Repository.ClientRepository;



@Service
public class MYUserDetailsService implements UserDetailsService {
	@Autowired
	private ClientRepository Cr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Client user = Cr.findByUsername(username);

		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());

	}

}
