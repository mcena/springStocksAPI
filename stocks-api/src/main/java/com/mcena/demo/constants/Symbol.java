package com.mcena.demo.constants;

import com.mcena.demo.parameter.ApiParameter;

public class Symbol implements ApiParameter {
	private String symbol;

	public Symbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String getKey() {
		return "symbol";
	}

	@Override
	public String getValue() {
		return symbol;
	}
}
