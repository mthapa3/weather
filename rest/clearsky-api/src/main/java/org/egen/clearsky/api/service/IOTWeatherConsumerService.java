package org.egen.clearsky.api.service;

import org.egen.clearsky.api.entity.WeatherData;

public interface IOTWeatherConsumerService {

	public void submitWeatherData(WeatherData weatherData);
}
