package com.example.ClimaApi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.ClimaApi.repository")
public class ClimaApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClimaApiApplication.class, args);
	}

}
