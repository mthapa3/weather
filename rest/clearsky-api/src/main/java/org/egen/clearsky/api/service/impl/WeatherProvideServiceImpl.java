package org.egen.clearsky.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.egen.clearsky.api.constants.URI;
import org.egen.clearsky.api.entity.WeatherData;
import org.egen.clearsky.api.exception.BadRequestException;
import org.egen.clearsky.api.exception.NotFoundException;
import org.egen.clearsky.api.repository.WeatherRepository;
import org.egen.clearsky.api.service.WeatherProviderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class WeatherProvideServiceImpl implements WeatherProviderService {

	private WeatherRepository weatherRepository;

	public WeatherProvideServiceImpl(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	@Override
	public List<String> findAll() {
		List<String> data = weatherRepository.findAll().stream().map(a -> a.getCity()).distinct()
				.collect(Collectors.toList());
		return data;
	}

	@Override
	public WeatherData findWeatherByCity(String city) {
		return weatherRepository.findTopByCityOrderByTimestampDesc(city);
	}

	@Override
	public String findPropertyByCity(String property, String city) {
		if (property == null || property.isEmpty())
			throw new BadRequestException("Property Not found.");
		WeatherData w = findWeatherByCity(city);
		switch (property.toLowerCase()) {
		case URI.DESCRIPTION:
			return w.getDescription();
		case URI.HUMIDITY:
			return w.getHumidity();
		case URI.PRESSURE:
			return w.getPressure();
		case URI.TEMPERATURE:
			return w.getTemperature();
		case URI.WIND:
			return w.getWind().toString();
		}
		throw new NotFoundException("City " + city + " does not exist");
	}

	@Override
	public List<WeatherData> findDailyAveWeatherByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeatherData> findHourlyAveWeatherByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
