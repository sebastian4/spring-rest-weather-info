package com.cyberiq.weatherinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyberiq.weatherinfo.model.CityWeatherInfo;
import com.cyberiq.weatherinfo.request.CityWeatherRequest;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class CityWeatherController {
	
	private static final Logger logger = LoggerFactory.getLogger(CityWeatherController.class);
	
	private CityWeatherRequest httpRequest = new CityWeatherRequest("http://api.openweathermap.org/data/2.5/weather");
	
	@RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
	public @ResponseBody CityWeatherInfo getCity(@PathVariable("name") String cityName) {
		logger.debug("HTTP GET Request - Start getCity");
		CityWeatherInfo cityInfo = httpRequest.getCityInformation(cityName);
		logger.debug("HTTP GET Response - End getCity");
		return cityInfo;
	}

}
