package com.uniqur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniqurApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniqurApplication.class, args);
		System.out.println("Welcome to uniqur");
		System.out.println("Server is running on port 8080");
	}

}
