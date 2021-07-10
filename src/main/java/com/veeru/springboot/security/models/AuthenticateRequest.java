/**
 * 
 */
package com.veeru.springboot.security.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author virupaksha.kuruva
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateRequest {

	private String userName;
	private String password;
}
