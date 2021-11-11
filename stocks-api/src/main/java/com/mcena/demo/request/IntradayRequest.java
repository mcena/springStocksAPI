package com.mcena.demo.request;

public class IntradayRequest {
	private String companyName;
	private Integer interval;
	
	
	public IntradayRequest() {
		
	}
	
	public IntradayRequest(String companyName, Integer interval) {
		this.companyName = companyName;
		this.interval = interval;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	
	
}
