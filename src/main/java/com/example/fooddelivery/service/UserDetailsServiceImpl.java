package com.example.fooddelivery.service;
import com.example.fooddelivery.model.User;
import com.example.fooddelivery.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException("User not found");

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
		);
	}

	public User registerUser(User user) {
		user.setPassword("password");
		user.setRole("ROLE_USER");
		return userRepository.save(user);
	}
}