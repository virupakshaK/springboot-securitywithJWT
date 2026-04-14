/**
 * 
 */
package com.veeru.springboot.exceptions;

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

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

}
