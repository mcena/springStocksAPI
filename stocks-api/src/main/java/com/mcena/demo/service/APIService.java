package com.mcena.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mcena.demo.constants.Function;
import com.mcena.demo.parameter.ApiParameter;
import com.mcena.demo.request.ExchangeRateRequest;
import com.mcena.demo.request.IntradayRequest;

@Service
public class APIService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String viewCompany(String companyName) {
		
		String url = String.format(
				"https://www.alphavantage.co/query?function=OVERVIEW&symbol=%s&apikey=YQG3MJRGM3JXOCGQ", companyName);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}

	public String viewIntraday(IntradayRequest intradayRequest) {
		String companyName = intradayRequest.getCompanyName();
		int interval = intradayRequest.getInterval();
		String url = String.format(
				"https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=%smin&apikey=YQG3MJRGM3JXOCGQ",
				companyName, interval);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}

	public String viewDailyAdjusted(String companyName) {
		String url = String.format(
				"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=%s&apikey=YQG3MJRGM3JXOCGQ",
				companyName);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}
	
	public String viewExchangeRate(ExchangeRateRequest exchangeRateRequest) {
		String fromCurrency = exchangeRateRequest.getFromCurrency();
		String toCurrency = exchangeRateRequest.getToCurrency();
		
		String url = String.format(
				"https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=%s&to_currency=%s&apikey=YQG3MJRGM3JXOCGQ",
				fromCurrency, toCurrency);

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

		String response = restTemplate.getForObject(url, String.class);

		return response;
	}
}
