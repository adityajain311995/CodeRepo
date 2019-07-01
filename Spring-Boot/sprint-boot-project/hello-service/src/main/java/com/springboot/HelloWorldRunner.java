package com.springboot;

public class HelloWorldRunner {

	public HelloWorldRunner() {
		System.out.println("Hello World!");
	}
	
	public HelloWorldRunner(String var) {
		System.out.println(String.format("Hello %s!", var));
	}

}
