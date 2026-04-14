/**
 * 
 */
package com.veeru.springboot.exceptions;

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
public class BadCredentialException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorInfo errorInfo;
	public BadCredentialException(int errorCode, String error) {
		this.errorInfo = new ErrorInfo(error, errorCode);
	}
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	

}
