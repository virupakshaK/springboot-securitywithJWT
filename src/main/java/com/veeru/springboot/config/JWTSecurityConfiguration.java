/**
 * 
 */
package com.veeru.springboot.config;

import com.veeru.springboot.filter.JWTFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author virupaksha.kuruva
 *
 */
@Configuration
@EnableWebSecurity
public class JWTSecurityConfiguration {

	@Autowired
	private final JWTFilter jwtFilter;

	JWTSecurityConfiguration(JWTFilter jwtFilter){
		this.jwtFilter = jwtFilter;
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable) // or   http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
												.requestMatchers("/bookstore/get").hasAnyRole("ADMIN", "USER")
												.requestMatchers("/bookstore/save").hasRole("ADMIN")
												.requestMatchers("/bookstore/update").hasRole("ADMIN")
												.requestMatchers("/bookstore/delete").hasRole("ADMIN")
								                .requestMatchers("/bookstore/greetings/**").permitAll()
												.requestMatchers("/h2-console/**").permitAll()
												.requestMatchers("/user/authenticate").permitAll()
												.anyRequest().authenticated()
				                       )
				.exceptionHandling(ex -> ex.authenticationEntryPoint((request, response, authException) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
				}))
		        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(httpBaic -> {}) //Optional
				//.cors(cors -> {} ) //Enable CORS
		        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
		        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

		return http.build();
	}

	// Password Encoder Bean
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
	}
}
