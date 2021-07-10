/**
 * 
 */
package com.veeru.springboot.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author virupaksha.kuruva
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value=BookNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleBookNotFoundException(BookNotFoundException bookNotFoundException){
		
		return new ResponseEntity<ErrorInfo>(bookNotFoundException.getErrorInfo(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmptyInputParam.class)
	public ResponseEntity<ErrorInfo> handleEmptyInputException(EmptyInputParam emptyInputParam){
		return new ResponseEntity<ErrorInfo>(emptyInputParam.getErrorInfo(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AuthenticationDetailsNotFound.class)
	public ResponseEntity<ErrorInfo> handleAuthenticationDetailsNotFound(AuthenticationDetailsNotFound authenticationDetailsNotFound){
		return new ResponseEntity<ErrorInfo>(authenticationDetailsNotFound.getErrorInfo(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = BadCredentialException.class)
	public ResponseEntity<ErrorInfo> handleBadCredentialException(BadCredentialException badCredentialException){
		return new ResponseEntity<ErrorInfo>(badCredentialException.getErrorInfo(), HttpStatus.BAD_REQUEST);
	}
}
