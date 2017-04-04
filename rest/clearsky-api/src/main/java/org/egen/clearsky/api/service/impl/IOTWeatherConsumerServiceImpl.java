package org.egen.clearsky.api.service.impl;

import org.egen.clearsky.api.entity.WeatherData;
import org.egen.clearsky.api.repository.WeatherRepository;
import org.egen.clearsky.api.service.IOTWeatherConsumerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IOTWeatherConsumerServiceImpl implements IOTWeatherConsumerService {

	private WeatherRepository weatherRepository;

	public IOTWeatherConsumerServiceImpl(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	@Override
	@Transactional
	public void submitWeatherData(WeatherData weatherData) {
		weatherRepository.insert(weatherData);

	}

}
