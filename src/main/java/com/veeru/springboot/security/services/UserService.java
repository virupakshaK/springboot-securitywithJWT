/**
 * 
 */
package com.veeru.springboot.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.veeru.springboot.security.models.MyUserDetails;
import com.veeru.springboot.security.models.UserInfo;
import com.veeru.springboot.security.repo.UserRepository;

/**
 * @author virupaksha.kuruva
 *
 */
@Service
public class UserService implements  UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userRepository.findUserByUserName(userName);
		userInfo.orElseThrow(() -> new UsernameNotFoundException("User not found."));
		return userInfo.map(MyUserDetails::new).get();
	}

}
