/**
 * 
 */
package com.veeru.springboot.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veeru.springboot.security.models.UserInfo;

/**
 * @author virupaksha.kuruva
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{

	public Optional<UserInfo> findUserByUserName(String name);
}
