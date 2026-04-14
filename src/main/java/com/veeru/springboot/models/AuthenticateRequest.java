/**
 * 
 */
package com.veeru.springboot.models;

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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
