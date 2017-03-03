package org.egen.clearsky.api.repository;

import java.util.List;

import org.egen.clearsky.api.entity.WeatherData;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WeatherRepository extends MongoRepository<WeatherData, String>, WeatherRepositoryCustom {

	@Query("{ 'city' : {$regex : ?0, $options: 'i'} }")
	public WeatherData findTopByCityOrderByTimestampDesc(String city);

	@Query("{'city' : ?0 , timestamp: {$dayOfMonth: '$timestamp'}}")
	public List<WeatherData> findWeatherByCityAndDate(String city, String date);

}
