package com.mcena.demo.request;

public class IntradayRequest {
	private String companyName;
	private String interval;
	
	
	public IntradayRequest() {
		
	}
	
	public IntradayRequest(String companyName, String interval) {
		this.companyName = companyName;
		this.interval = interval;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}
	
	
}
