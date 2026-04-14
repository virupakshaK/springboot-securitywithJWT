/**
 * 
 */
package com.veeru.springboot.filter;

import com.veeru.springboot.utils.JWTUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author virupaksha.kuruva
 *
 */
@Component
@Slf4j
public class JWTFilter extends OncePerRequestFilter{

	private final UserDetailsService userDetailsService;
	private final JWTUtility jwtUtility;
	public JWTFilter(UserDetailsService userDetailsService, JWTUtility jwtUtility){
		this.userDetailsService = userDetailsService;
		this.jwtUtility = jwtUtility;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");
		String token = null;
		String userName = null;
		try {
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);
			userName = jwtUtility.extractUsername(token);
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

			if (jwtUtility.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		} catch (Exception ex) {
			log.error("JWT Authentication failed: {}", ex.getMessage());
			// Optional: clear context explicitly
			SecurityContextHolder.clearContext();
		}

		chain.doFilter(request, response);
	}

}
