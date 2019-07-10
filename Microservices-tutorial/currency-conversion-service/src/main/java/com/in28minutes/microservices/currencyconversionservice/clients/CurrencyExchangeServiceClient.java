package com.in28minutes.microservices.currencyconversionservice.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.currencyconversionservice.beans.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceClient {

	@GetMapping("/currency-exchange/from/{fromCurr}/to/{toCurr}")
	public CurrencyConversionBean retreiveExchangeValue(
			@PathVariable("fromCurr") String fromCurr, 
			@PathVariable("toCurr") String toCurr);
	
}
