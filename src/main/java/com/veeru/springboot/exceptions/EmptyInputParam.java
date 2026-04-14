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
public class EmptyInputParam extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorInfo errorInfo;
	
	public EmptyInputParam(String error, int errorCode) {
		
		errorInfo = new ErrorInfo(error, errorCode);
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
