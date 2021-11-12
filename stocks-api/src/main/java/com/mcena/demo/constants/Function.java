package com.mcena.demo.constants;

import com.mcena.demo.parameter.ApiParameter;

public enum Function implements ApiParameter{
	// TIME SERIES
	OVERVIEW("OVERVIEW"),
	TIME_SERIES_INTRADAY("TIME_SERIES_INTRADAY"),
	TIME_SERIES_DAILY_ADJUSTED("TIME_SERIES_DAILY_ADJUSTED"),
	
	
	// FOREX EXCHANGE RATES
	CURRENCY_EXCHANGE_RATE("CURRENCY_EXCHANGE_RATE");
	
	
	private final String urlParameter;
	
	Function(String urlParameter) {
		this.urlParameter = urlParameter;
	}
	
	@Override
	public String getKey() {
		return "function";
	}
	
	@Override
	public String getValue() {
		return urlParameter;
	}
	
}
