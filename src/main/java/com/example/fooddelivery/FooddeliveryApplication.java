package com.example.fooddelivery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.fooddelivery.model.User;
import com.example.fooddelivery.repository.UserRepository;

@SpringBootApplication
public class FooddeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooddeliveryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initUsers(UserRepository userRepo, PasswordEncoder encoder) {
		return args -> {
			User user = new User();
			user.setUsername("admin");
			user.setPassword(encoder.encode("password"));
			user.setRole("ROLE_USER");
			userRepo.save(user);
		};
	}
}