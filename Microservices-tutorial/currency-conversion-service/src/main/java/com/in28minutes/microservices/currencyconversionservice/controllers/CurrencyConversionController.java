package com.in28minutes.microservices.currencyconversionservice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservices.currencyconversionservice.beans.CurrencyConversionBean;
import com.in28minutes.microservices.currencyconversionservice.feignclients.CurrencyExchangeServiceClient;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment env;
	@Autowired
	private CurrencyExchangeServiceClient currencyExchangeService;;
	
	@GetMapping("/currency-conversion-feign/from/{fromCurr}/to/{toCurr}/quantity/{quantity}")
	public CurrencyConversionBean getConversion(
			@PathVariable String fromCurr,
			@PathVariable String toCurr,
			@PathVariable Double quantity) {
		CurrencyConversionBean body = currencyExchangeService.retreiveExchangeValue(fromCurr, toCurr);
		body.setId(2000L);
		body.setTotalRequestedAmount(quantity*body.getConversionMultiple());
		body.setQuantity(quantity);
		return body;
	}
	
	@GetMapping("/currency-conversion/from/{fromCurr}/to/{toCurr}/quantity/{quantity}")
	public CurrencyConversionBean getConversion_nonFeign(
			@PathVariable String fromCurr,
			@PathVariable String toCurr,
			@PathVariable Double quantity) {
		Map<String,Object> uriVariables = new HashMap<>();
		uriVariables.put("fromCurr", fromCurr);
		uriVariables.put("toCurr", toCurr);
		ResponseEntity<CurrencyConversionBean> responseEntity = 
				new RestTemplate()
				.getForEntity(
						"http://localhost:8000/currency-exchange/from/{fromCurr}/to/{toCurr}", 
						CurrencyConversionBean.class, 
						uriVariables);
		
		CurrencyConversionBean body = responseEntity.getBody();
		body.setId(2000L);
		body.setTotalRequestedAmount(quantity*body.getConversionMultiple());
		body.setQuantity(quantity);
		body.setPort(Integer.parseInt(env.getProperty("server.port")));
		return body;
	}
}
