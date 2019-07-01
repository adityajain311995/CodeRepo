package com.hello.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.HelloWorldRunner;

@Configuration
public class HelloServiceAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public HelloWorldRunner helloBean() {
		return new HelloWorldRunner();
	}
	
}
