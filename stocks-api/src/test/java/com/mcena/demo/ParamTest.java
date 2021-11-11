package com.mcena.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import com.mcena.demo.constants.Function;
import com.mcena.demo.constants.Symbol;
import com.mcena.demo.parameter.ApiParameterBuilder;

class ParamTest {

	@Test
	void test() throws Exception {
		ApiParameterBuilder builder = new ApiParameterBuilder();
		
		String buildUrl = builder.getParameters(Function.OVERVIEW, new Symbol("AAPL"));
		
		System.out.println(buildUrl);
		
		assertThat(buildUrl,is(equalTo("https://www.alphavantage.co/query?&function=OVERVIEW&symbol=AAPL&apikey=YQG3MJRGM3JXOCGQ")));
		
	}

}
