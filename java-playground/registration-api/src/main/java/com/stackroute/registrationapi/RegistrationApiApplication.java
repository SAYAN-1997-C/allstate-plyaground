package com.stackroute.registrationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RegistrationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApiApplication.class, args);
	}

}
