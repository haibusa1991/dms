package com.dms.beiam.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dms.beiam"})
public class BeiamApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeiamApplication.class, args);
	}

}
