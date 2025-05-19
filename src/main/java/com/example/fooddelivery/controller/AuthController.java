package com.example.fooddelivery.controller;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fooddelivery.model.User;
import com.example.fooddelivery.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	// @Autowired
	// private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					authRequest.getUsername(),
					authRequest.getPassword()
				)
			);

			//UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
			//String token = jwtUtil.generateToken(userDetails);
			//return ResponseEntity.ok(Map.of("token", token));

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/index.html"));
			return new ResponseEntity<>(headers, HttpStatus.FOUND);

		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		User created = userDetailsService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
}
}

class AuthRequest {
	private String username;
	private String password;

	public String getUsername() { return username; }
	public void setUsername(String u) { username = u; }
	public String getPassword() { return password; }
	public void setPassword(String p) { password = p; }
}