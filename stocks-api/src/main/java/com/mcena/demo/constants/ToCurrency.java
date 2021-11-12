package com.mcena.demo.constants;

import com.mcena.demo.parameter.ApiParameter;

public class ToCurrency implements ApiParameter {
	
	private String toCurrency;
	
	public ToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	@Override
	public String getKey() {
		return "to_currency";
	}

	@Override
	public String getValue() {
		return toCurrency;
	}

}
