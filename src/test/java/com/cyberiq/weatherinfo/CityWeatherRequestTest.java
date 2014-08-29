package com.cyberiq.weatherinfo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cyberiq.weatherinfo.model.CityWeatherInfo;
import com.cyberiq.weatherinfo.request.CityWeatherRequest;

public class CityWeatherRequestTest {

	private static CityWeatherRequest httpRequest = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		httpRequest = new CityWeatherRequest("http://api.openweathermap.org/data/2.5/weather");
	}

	@Test
	public void testGetCityInformationBaltimore() {
		CityWeatherInfo cityInfo = httpRequest.getCityInformation("Baltimore,md");
		assertEquals("must be same name city","Baltimore",cityInfo.getName());
	}

}
