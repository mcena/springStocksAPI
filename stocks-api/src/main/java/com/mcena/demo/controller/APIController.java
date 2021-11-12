package com.mcena.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcena.demo.request.Company;
import com.mcena.demo.request.ExchangeRateRequest;
import com.mcena.demo.request.IntradayRequest;
import com.mcena.demo.service.APIService;

@RestController
public class APIController {

	@Autowired
	private APIService apiService;
	
	@PostMapping("/viewcompany")
	public String viewCompany(@RequestBody Company company) {
		return apiService.viewCompany(company);
	}
	
	@PostMapping("/intraday")
	public String viewIntraDay(@RequestBody IntradayRequest intradayRequest) {
		return apiService.viewIntraday(intradayRequest);
	}
	
	@PostMapping("/dailyadjusted")
	public String viewDailyAdjusted(@RequestBody Company company) {
		return apiService.viewDailyAdjusted(company);
	}
	
	@PostMapping("/exchangerate")
	public String viewForexExchangeRate(@RequestBody ExchangeRateRequest exchangeRateRequest) {
		return apiService.viewExchangeRate(exchangeRateRequest);
	}
	
	
	
}
