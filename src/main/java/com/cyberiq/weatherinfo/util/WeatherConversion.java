package com.cyberiq.weatherinfo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.cyberiq.weatherinfo.model.City;
import com.cyberiq.weatherinfo.model.CityWeatherInfo;

public class WeatherConversion {
	
	protected SimpleDateFormat dateFormat = null;
	
	public WeatherConversion(String format) {
		//dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS",Locale.US);
		dateFormat = new SimpleDateFormat(format,Locale.US);
	}
	
	public CityWeatherInfo cityToCityWeatherInfo(City city) {
		
		if (null == city)
			return null;
		
		CityWeatherInfo cityInfo = new CityWeatherInfo();
		
		cityInfo.setName(city.getName());
		cityInfo.setTemperature(kelvinToFahrenheit(city.getMain().getTemp()));
		cityInfo.setMin(kelvinToFahrenheit(city.getMain().getTempMin()));
		cityInfo.setMax(kelvinToFahrenheit(city.getMain().getTempMax()));
		cityInfo.setPressure((double)city.getMain().getPressure());
		cityInfo.setHumidity((double)city.getMain().getHumidity());
		if (city.getWeather().size()>0) {
			cityInfo.setMain(city.getWeather().get(0).getMain());
			cityInfo.setDescription(city.getWeather().get(0).getDescription());
			cityInfo.setIcon(city.getWeather().get(0).getIcon());
		}
		Long ldate = (long) ((long)city.getDt()*1000);
		Date date=new Date(ldate);
		
		cityInfo.setDate(dateFormat.format(date));
		
		return cityInfo;
	}
	
	public double kelvinToFahrenheit(double kelvin) {
		//F =(K - 273.15)* 1.8000 + 32.00
		return ( (kelvin - 273.15) * 1.8000 ) + 32.00;
	}

}
