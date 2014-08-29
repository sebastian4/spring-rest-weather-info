package com.cyberiq.weatherinfo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cyberiq.weatherinfo.model.City;
import com.cyberiq.weatherinfo.model.CityWeatherInfo;
import com.cyberiq.weatherinfo.util.WeatherConversion;

public class WeatherConversionTest {
	
	private static WeatherConversion converter = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		converter = new WeatherConversion("yyyy-MM-dd HH:mm:ss");
	}

	@Test
	public void testCityToCityWeatherInfoNull() {
		City city = null;
		CityWeatherInfo cityInfo = converter.cityToCityWeatherInfo(city);
	    assertEquals("must be null",cityInfo,null);
	}

}
