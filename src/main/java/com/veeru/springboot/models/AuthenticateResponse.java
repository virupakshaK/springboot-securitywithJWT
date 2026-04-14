/**
 * 
 */
package com.veeru.springboot.models;

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

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
