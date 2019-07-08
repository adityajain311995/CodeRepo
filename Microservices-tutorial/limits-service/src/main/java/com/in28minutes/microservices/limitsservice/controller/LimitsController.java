package com.in28minutes.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitsservice.beans.Limit;
import com.in28minutes.microservices.limitsservice.configuration.PropertyConfiguration;

@RestController
public class LimitsController {

	@Autowired
	private PropertyConfiguration properties;
	
	@GetMapping("/limits")
	public Limit limits() {
		return new Limit(properties.getMinimum(), properties.getMaximum());
	}
	
}
