package com.cyberiq.weatherinfo.model;

public class CityWeatherInfo {

	private String name;
	private String main;
	private String icon;
	private String description;
	private String date;
	private Double temperature;
	private Double min;
	private Double max;
	private Double pressure;
	private Double humidity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "CityWeatherInfo ["
				+ " name=" + name 
				+ ", main=" + main 
				+ ", icon=" + icon 
				+ ", description=" + description 
				+ ", date=" + date
				+ ", temperature=" + temperature 
				+ ", min=" + min 
				+ ", max=" + max 
				+ ", pressure=" + pressure 
				+ ", humidity=" + humidity
				+ " ]";
	}

}
