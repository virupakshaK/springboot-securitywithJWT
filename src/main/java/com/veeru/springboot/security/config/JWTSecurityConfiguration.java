/**
 * 
 */
package com.veeru.springboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.veeru.springboot.security.filter.JWTFilter;
import com.veeru.springboot.security.services.UserService;

/**
 * @author virupaksha.kuruva
 *
 */
@EnableWebSecurity
public class JWTSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService userService;
	@Autowired
	JWTFilter jwtFilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/bookstore/get").hasAnyRole("ADMIN","USER")
		                        .antMatchers("/bookstore/save").hasRole("ADMIN")
		                        .antMatchers("/bookstore/update").hasRole("ADMIN")
		                        .antMatchers("/bookstore/delete").hasRole("ADMIN")
		                        .and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
		                        .antMatchers("/user/authenticate").permitAll()
		                        .and().httpBasic();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.headers().frameOptions().disable();
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
}
