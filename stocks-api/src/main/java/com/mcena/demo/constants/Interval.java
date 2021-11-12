package com.mcena.demo.constants;

import com.mcena.demo.parameter.ApiParameter;

public enum Interval implements ApiParameter{
	ONE_MIN("1min"), 
	FIVE_MIN("5min"), 
	TEN_MIN("10min"), 
	FIFTEEN_MIN("15min"), 
	THIRTY_MIN("30min"), 
	SIXTY_MIN("60min");
	
	private final String interval;

	Interval(String interval) {
		this.interval = interval;
	}

	@Override
	public String getKey() {
		return "interval";
	}

	@Override
	public String getValue() {
		return interval;
	}
	
	public static Interval valueOfInterval(String interval) {
		for(Interval i : Interval.values()) {
			if(i.interval.equals(interval)) {
				return i;
			}
		}
		return null;
	}

}
