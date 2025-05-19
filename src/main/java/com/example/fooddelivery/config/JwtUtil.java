package com.example.fooddelivery.config;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {

	private final String SECRET_KEY = "supersecretkey";

	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
			.setSubject(userDetails.getUsername())
			.claim("role", userDetails.getAuthorities().iterator().next().getAuthority())
			.setIssuedAt(new Date())
			.setExpiration(Date.from(Instant.now().plusSeconds(3600)))
			.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
			.compact();
	}

	public String extractUsername(String token) {
		return Jwts.parser()
			.setSigningKey(SECRET_KEY)
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		Date expiration = Jwts.parser()
			.setSigningKey(SECRET_KEY)
			.parseClaimsJws(token)
			.getBody()
			.getExpiration();
		return expiration.before(new Date());
	}
}