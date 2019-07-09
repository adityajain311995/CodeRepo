package com.in28minutes.microservices.currencyexchangeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.beans.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.repository.ExchangeValueRepository;


@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	@Autowired
	private ExchangeValueRepository exchangeRepo;
	
	@GetMapping("/currency-exchange/from/{fromCurr}/to/{toCurr}")
	public ExchangeValue retreiveExchangeValue(
			@PathVariable String fromCurr, 
			@PathVariable String toCurr) {
		
		ExchangeValue exchangeValue = exchangeRepo.findByFromCurrAndToCurr(fromCurr, toCurr);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("server.port")));
		return exchangeValue;
	}
	
	@GetMapping("/currency-exchange")
	public List<ExchangeValue> retreiveAllExchange(){
		return exchangeRepo.findAll();
	}

}
