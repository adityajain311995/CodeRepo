package com.in28minutes.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.microservices.currencyexchangeservice.beans.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromCurrAndToCurr(String from, String to);
	
}
