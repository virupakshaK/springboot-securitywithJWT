/**
 * 
 */
package com.veeru.springboot.security.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author virupaksha.kuruva
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {

	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private int id;
	private String userName;
	private String password;
	private boolean active;
	private String roles;
	
}
