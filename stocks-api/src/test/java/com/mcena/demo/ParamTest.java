package com.mcena.demo;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import com.mcena.demo.constants.Function;
import com.mcena.demo.constants.Symbol;
import com.mcena.demo.parameter.ApiParameterBuilder;
import com.mcena.demo.constants.*;

class ParamTest {

	@Test
	void testCompanyOverviewParam() throws Exception {
		ApiParameterBuilder builder = new ApiParameterBuilder();
		
		String buildUrl = builder.getParameters(Function.OVERVIEW, new Symbol("AAPL"));
		
		System.out.println(buildUrl);
		
		assertThat(buildUrl,is(equalTo("https://www.alphavantage.co/query?&function=OVERVIEW&symbol=AAPL&apikey=demo")));
		
	}
	
	@Test
	void testIntraDayParam() throws Exception {
		ApiParameterBuilder builder = new ApiParameterBuilder();

		String buildUrl = builder.getParameters(Function.TIME_SERIES_INTRADAY, new Symbol("AAPL"), Interval.valueOfInterval("15min"));

		System.out.println(buildUrl);

		assertThat(buildUrl, is(
				equalTo("https://www.alphavantage.co/query?&function=TIME_SERIES_INTRADAY&symbol=AAPL&interval=15min&apikey=demo")));
	}
	
	@Test
	void testExchangeRate() throws Exception {
		ApiParameterBuilder builder = new ApiParameterBuilder();

		String buildUrl = builder.getParameters(Function.CURRENCY_EXCHANGE_RATE, new FromCurrency("USD"), new ToCurrency("PHP"));

		System.out.println(buildUrl);

		assertThat(buildUrl, is(
				equalTo("https://www.alphavantage.co/query?&function=TIME_SERIES_INTRADAY&symbol=AAPL&interval=15min&apikey=demo")));
	}

}
