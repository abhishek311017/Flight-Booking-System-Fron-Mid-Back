package io.project.PassengerLogin.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.project.PassengerLogin.models.Users;
import io.project.PassengerLogin.repository.UserRepository;

@Component
public class MongoUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}