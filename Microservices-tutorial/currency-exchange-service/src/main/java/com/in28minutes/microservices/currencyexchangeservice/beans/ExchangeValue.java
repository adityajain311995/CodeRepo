package com.in28minutes.microservices.currencyexchangeservice.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

//@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, include=As.WRAPPER_OBJECT)
@Entity(name="Exchange_Value")
public class ExchangeValue {

	@Id
	@GeneratedValue
	private Long id;
	private String fromCurr;
	private String toCurr;
	private Double conversionMultiple;
	@Transient
	private int port;
	
	public ExchangeValue() {
		
	}
	
	public ExchangeValue(String from, String to, Double conversionMultiple) {
		super();
		this.fromCurr = from;
		this.toCurr = to;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCurr() {
		return fromCurr;
	}

	public void setFromCurr(String fromCurr) {
		this.fromCurr = fromCurr;
	}

	public String getToCurr() {
		return toCurr;
	}

	public void setToCurr(String toCurr) {
		this.toCurr = toCurr;
	}

	public Double getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(Double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
