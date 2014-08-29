package com.cyberiq.weatherinfo.request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cyberiq.weatherinfo.model.City;
import com.cyberiq.weatherinfo.model.CityWeatherInfo;
import com.cyberiq.weatherinfo.util.WeatherConversion;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CityWeatherRequest {
	
	private static final Logger logger = LoggerFactory.getLogger(CityWeatherRequest.class);
	
	protected String baseUrl;
	protected URL url;
	protected ObjectMapper mapper;
	protected WeatherConversion converter;
	
	public CityWeatherRequest(String baseUrl) {
		this.baseUrl = baseUrl;
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		converter = new WeatherConversion("yyyy-MM-dd HH:mm:ss");
	}
	
	public CityWeatherInfo getCityInformation(String cityName) {
		logger.debug("Start getCityInformation");
		
		CityWeatherInfo cityInfo = null;
		
		try {
			//url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityName);
			url = new URL(baseUrl+"?q="+cityName);
			URLConnection connection = url.openConnection(); 
			City city = mapper.readValue(connection.getInputStream(), City.class);
			cityInfo = converter.cityToCityWeatherInfo(city);
			logger.debug(cityInfo.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.debug("End getCityInformation");
		
		return cityInfo;
	}

}
