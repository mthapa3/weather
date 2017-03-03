package org.egen.clearsky.api.repository;

import java.util.List;

import org.egen.clearsky.api.entity.WeatherData;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepositoryCustom {

	List<WeatherData> findDailyAveWeatherByCity(String city);
	
	List<WeatherData> findHourlyAveWeatherByCity(String city);
}
