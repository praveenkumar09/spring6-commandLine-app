package com.praveen.springguru.spring6_commandLine_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring6CommandLineAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6CommandLineAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
