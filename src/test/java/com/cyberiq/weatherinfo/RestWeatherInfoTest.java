package com.cyberiq.weatherinfo;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.cyberiq.weatherinfo.model.CityWeatherInfo;

public class RestWeatherInfoTest {

	private static final String baseUrl = "http://localhost:8080/spring-rest-jour-two/rest";
	private static RestTemplate restTemplate = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testCityWeatherInfo() {
		CityWeatherInfo cityInfo = restTemplate.getForObject(baseUrl+"/city/Baltimore,md", CityWeatherInfo.class);
		assertEquals("must be same name city","Baltimore",cityInfo.getName());
	}

}
