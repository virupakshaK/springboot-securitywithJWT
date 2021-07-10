/**
 * 
 */
package com.veeru.springboot.security.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author virupaksha.kuruva
 *
 */
@Getter
@Setter
public class AuthenticationDetailsNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorInfo errorInfo;
	
	public AuthenticationDetailsNotFound(int errorCode, String errorInfo) {
		this.errorInfo = new ErrorInfo(errorInfo,errorCode);
	}

}
