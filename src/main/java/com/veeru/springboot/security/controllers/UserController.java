/**
 * 
 */
package com.veeru.springboot.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veeru.springboot.security.exceptions.AuthenticationDetailsNotFound;
import com.veeru.springboot.security.exceptions.BadCredentialException;
import com.veeru.springboot.security.models.AuthenticateRequest;
import com.veeru.springboot.security.models.AuthenticateResponse;
import com.veeru.springboot.security.services.UserService;
import com.veeru.springboot.security.utils.JWTUtility;

/**
 * @author virupaksha.kuruva
 *
 */
// @CrossOrigin("localhost")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	JWTUtility jwtUtility;

	@RequestMapping("/authenticate")
	public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
		try {
			if (authenticateRequest == null ||authenticateRequest.getUserName() == null || "".equals(authenticateRequest.getUserName())) {
				throw new AuthenticationDetailsNotFound(400, "Authentication details not found.");
			}
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticateRequest.getUserName(), authenticateRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialException(401, "Invalid Credentials");
		}
		final UserDetails userDetails = userService.loadUserByUsername(authenticateRequest.getUserName());
		final String token = jwtUtility.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticateResponse(token));
	}
}
