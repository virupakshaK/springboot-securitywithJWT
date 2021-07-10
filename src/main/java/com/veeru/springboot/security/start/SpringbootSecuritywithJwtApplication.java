package com.veeru.springboot.security.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author virupaksha.kuruva
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.veeru.springboot")
@EnableJpaRepositories(basePackages = {"com.veeru.springboot"})
@EntityScan(basePackages = {"com.veeru.springboot"})
public class SpringbootSecuritywithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecuritywithJwtApplication.class, args);
	}

}
