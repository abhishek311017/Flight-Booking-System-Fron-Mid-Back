package io.project.PassengerLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.project.PassengerLogin.models.AuthRequest;
import io.project.PassengerLogin.services.MongoUserDetailsService;
import io.project.PassengerLogin.util.JwtUtil;

@RestController
@CrossOrigin(origins="*")
public class PassengerController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MongoUserDetailsService userService;

	@GetMapping("/")
	public String user() {
		return "Welcome user";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("Invalid username or password");
		}
		final UserDetails userDetails = userService.loadUserByUsername(authRequest.getEmail());
		final String token = jwtUtil.generateToken(userDetails);
		return token;
	}

}