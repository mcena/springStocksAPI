package com.mcena.demo.service;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mcena.demo.constants.FromCurrency;
import com.mcena.demo.constants.Function;
import com.mcena.demo.constants.Interval;
import com.mcena.demo.constants.Symbol;
import com.mcena.demo.constants.ToCurrency;
import com.mcena.demo.parameter.ApiParameterBuilder;
import com.mcena.demo.request.Company;
import com.mcena.demo.request.ExchangeRateRequest;
import com.mcena.demo.request.IntradayRequest;

@Service
public class APIService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private ApiParameterBuilder apiParameterBuilder;
	
	public APIService(ApiParameterBuilder apiParameterBuilder) {
		this.apiParameterBuilder = apiParameterBuilder;
	}
	 
	public String viewCompany(Company company) {
		
		String companyName = company.getCompanyName();
		
		String url = "";
		try {
			url = apiParameterBuilder.getParameters(Function.OVERVIEW, new Symbol(companyName));
		} catch (Exception e) {
			throw new IllegalStateException("there was an error on getting parameters!");
		}

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}

	public String viewIntraday(IntradayRequest intradayRequest) {
		String companyName = intradayRequest.getCompanyName();
		String interval = intradayRequest.getInterval().concat("min");
		
		
		String url = "";
		try {
			url = apiParameterBuilder.getParameters(Function.TIME_SERIES_INTRADAY, new Symbol(companyName), Interval.valueOfInterval(interval));
		} catch (Exception e) {
			throw new IllegalStateException("there was an error on getting parameters!");
		}

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}

	public String viewDailyAdjusted(Company company) {
		
		String companyName = company.getCompanyName();
		
		String url = "";
		try {
			url = apiParameterBuilder.getParameters(Function.TIME_SERIES_DAILY_ADJUSTED, new Symbol(companyName));
		} catch (Exception e) {
			throw new IllegalStateException("there was an error on getting parameters!");
		}

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}
	
	public String viewExchangeRate(ExchangeRateRequest exchangeRateRequest) {
		String fromCurrency = exchangeRateRequest.getFromCurrency();
		String toCurrency = exchangeRateRequest.getToCurrency();
		
		String url = "";
		try {
			url = apiParameterBuilder.getParameters(Function.CURRENCY_EXCHANGE_RATE, new FromCurrency(fromCurrency), new ToCurrency(toCurrency));
		} catch (Exception e) {
			throw new IllegalStateException("there was an error on getting parameters!");
		}

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}
}
