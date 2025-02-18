package com.dms.beiam.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dms.beiam"})
@EntityScan(basePackages = {"com.dms.beiam.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.dms.beiam.persistence.repositories"})
public class BeiamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeiamApplication.class, args);
	}

}
