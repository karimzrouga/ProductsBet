package com.products_bet.Controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.products_bet.Config.AuthentificationRequest;
import com.products_bet.Config.AuthentificationResponse;
import com.products_bet.Config.JwtUtil;
import com.products_bet.Config.MYUserDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class Logincontrollor {
	@Autowired
	private AuthenticationManager authmanager;
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private MYUserDetailsService msd;

	@PostMapping("/api/authen")
	public String login(@RequestBody AuthentificationRequest auth) throws Exception {
		try {
			authmanager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username or password", e);
		}
		final UserDetails userDetails = msd.loadUserByUsername(auth.getUsername());
		final String jwt = jwtutil.generateToken(userDetails);

		return new AuthentificationResponse(jwt).toString().replace("AuthentificationResponse(JWT=", "").replace(")",
				"");

	}

}
