package com.hello.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.HelloWorldRunner;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
public class HelloServiceAutoConfiguration {

	private final HelloServiceProperties properties;
	
	public HelloServiceAutoConfiguration(HelloServiceProperties properties) {
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean
	public HelloWorldRunner helloBean() {
		return new HelloWorldRunner(properties.getPrefix(), properties.getSuffix());
	}
	
}
