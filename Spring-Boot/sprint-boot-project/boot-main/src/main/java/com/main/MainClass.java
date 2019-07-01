package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.HelloWorldRunner;

@SpringBootApplication
public class MainClass {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainClass.class, args);
	}

	@Bean
	public HelloWorldRunner helloBean() {
		return new HelloWorldRunner("Aditya");
	}
	
}
