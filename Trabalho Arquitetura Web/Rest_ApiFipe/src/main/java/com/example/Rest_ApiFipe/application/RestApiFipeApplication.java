package com.example.Rest_ApiFipe.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.Rest_ApiFipe"})
@EnableMongoRepositories("com.example.Rest_ApiFipe.repository")

public class RestApiFipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiFipeApplication.class, args);
	}

}
