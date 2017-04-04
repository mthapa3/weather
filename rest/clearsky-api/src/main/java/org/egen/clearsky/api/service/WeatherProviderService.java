package org.egen.clearsky.api.service;

import java.util.List;

import org.egen.clearsky.api.entity.WeatherData;


public interface WeatherProviderService {
	public List<String> findAll();
	
	public WeatherData findWeatherByCity(String city);
	
	public String findPropertyByCity(String property , String city);
	
	public List<WeatherData> findDailyAveWeatherByCity(String city);
	
	public List<WeatherData> findHourlyAveWeatherByCity(String city);
}
