package com.mcena.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StocksApiApplicationTests {
	
	@Value("${user.apiKey}") 
	String apiKey;	

	@Test
	void contextLoads() {
		System.out.println(apiKey);
	}

}
