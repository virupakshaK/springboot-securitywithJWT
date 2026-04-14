/**
 * 
 */
package com.veeru.springboot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author virupaksha.kuruva
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorInfo {

	private String error;
	private int errorCode;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


}
