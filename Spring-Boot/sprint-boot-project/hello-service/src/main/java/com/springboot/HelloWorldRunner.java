package com.springboot;

public class HelloWorldRunner {

	private HelloWorldRunner() {}
	
	public HelloWorldRunner(String prefix, String suffix) {
		System.out.println(String.format("%s %s!", prefix, suffix));
	}

}
