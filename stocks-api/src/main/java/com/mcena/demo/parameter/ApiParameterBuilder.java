package com.mcena.demo.parameter;

import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Value;

public class ApiParameterBuilder {

	@Value("${user.apiKey}")
	private String apiKey;

	private final String BASE_URL = "https://www.alphavantage.co/query?";
	private StringBuilder stringBuilder;


	public ApiParameterBuilder() {
		this.stringBuilder = new StringBuilder();
	}

	public String getParameters(@Nullable ApiParameter... parameters) throws Exception {
		stringBuilder.append(BASE_URL);
		appendParameter(parameters);
		appendApiKey(loadApiKeyFromProps());
		return stringBuilder.toString();
	}

	private void appendParameter(@Nullable ApiParameter... apiParameter) {
		for (ApiParameter parameter : apiParameter) {
			appendValues(parameter.getKey(), parameter.getValue());
		}
	}

	private void appendValues(String key, String value) {
		String parameter = "&" + key + "=" + value;
		stringBuilder.append(parameter);
	}

	private void appendApiKey(String apiKey) {
		stringBuilder.append("&apikey=" + apiKey);
	}

	public String loadApiKeyFromProps() throws Exception {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("api.properties");
		Properties properties = new Properties();
		properties.load(inputStream);

		return properties.getProperty("user.apiKey");
	}
}
