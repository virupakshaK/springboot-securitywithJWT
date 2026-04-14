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
public class BookNotFoundException extends RuntimeException{

	private ErrorInfo errorInfo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String error, int errorCode){
		errorInfo = new ErrorInfo(error,errorCode);
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
