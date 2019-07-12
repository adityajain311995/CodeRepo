package com.in28minutes.microservices.currencyconversionservice.beans;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

//@JsonTypeName("currency-conversion")
//@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class CurrencyConversionBean {

	private Long id;
	private String fromCurr;
	private String toCurr;
	private Double quantity;
	private Double conversionMultiple;
	private Double totalRequestedAmount;
	private int port;

	public CurrencyConversionBean() {
	}

	public CurrencyConversionBean(Long id, String fromCurr, String toCurr, Double quantity, Double conversionMultiple,
			Double totalRequestedAmount, int port) {
		super();
		this.id = id;
		this.fromCurr = fromCurr;
		this.toCurr = toCurr;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalRequestedAmount = totalRequestedAmount;
		this.port = port;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(Double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public Double getTotalRequestedAmount() {
		return totalRequestedAmount;
	}

	public void setTotalRequestedAmount(Double totalRequestedAmount) {
		this.totalRequestedAmount = totalRequestedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
