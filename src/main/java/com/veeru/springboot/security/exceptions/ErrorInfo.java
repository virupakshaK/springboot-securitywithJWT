/**
 * 
 */
package com.veeru.springboot.security.exceptions;

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
	
	
}
