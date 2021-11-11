package com.mcena.demo.request;

public class ExchangeRateRequest {
	private String fromCurrency;
	private String toCurrency;
	
	private ExchangeRateRequest() {
		
	}
	
	private ExchangeRateRequest(String fromCurrency, String toCurrency) {
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	
}
