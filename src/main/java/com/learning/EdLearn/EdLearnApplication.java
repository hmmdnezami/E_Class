package com.learning.EdLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.learning.EdLearn.models")
public class EdLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdLearnApplication.class, args);
	}

}
