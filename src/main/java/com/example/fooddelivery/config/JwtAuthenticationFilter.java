package com.example.fooddelivery.config;
import com.example.fooddelivery.service.UserDetailsServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final UserDetailsServiceImpl userDetailsService;
	private final JwtUtil jwtUtil;

	public JwtAuthenticationFilter(UserDetailsServiceImpl uds, JwtUtil jwtUtil) {
		this.userDetailsService = uds;
		this.jwtUtil = jwtUtil;
	}

	@SuppressWarnings("null")
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)
									throws ServletException, IOException {

		final String authHeader = request.getHeader("Authorization");
		String username = null;
		String jwt = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			try {
				username = jwtUtil.extractUsername(jwt);
			} catch (Exception e) { }
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authToken =
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}