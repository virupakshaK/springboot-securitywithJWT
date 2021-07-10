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
public class BookNotFoundException extends RuntimeException{

	private ErrorInfo errorInfo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(String error, int errorCode){
		errorInfo = new ErrorInfo(error,errorCode);
	}

}
