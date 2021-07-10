/**
 * 
 */
package com.veeru.springboot.security.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author virupaksha.kuruva
 *
 */
@Data
@NoArgsConstructor
public class AuthenticateResponse {

	private String jwt;
	
	public AuthenticateResponse(String jwt) {
		this.jwt = jwt;
	}
}
