package org.egen.clearsky.api.repository.impl;

import java.util.List;

import org.egen.clearsky.api.entity.WeatherData;
import org.egen.clearsky.api.repository.WeatherRepositoryCustom;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;

public class WeatherRepositoryImpl implements WeatherRepositoryCustom {

	private final MongoTemplate mongoTemplate;

	public WeatherRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<WeatherData> findDailyAveWeatherByCity(String city) {
		ProjectionOperation project = Aggregation.project("_id", "city", "pressure", "temperature", "humidity")
				.andExpression("dayOfYear(timestamp)").as("timestamp");
		MatchOperation match = Aggregation.match(Criteria.where("city").is(city.toLowerCase()));
		GroupOperation groupByDayOfYear = Aggregation.group("timestamp");
		Aggregation aggregation = Aggregation.newAggregation(project, match, groupByDayOfYear.addToSet("_id").as("id")
				.avg("pressure").as("pressure").avg("temperature").as("temperature").avg("humidity").as("humidity"));
		AggregationResults<WeatherData> results = mongoTemplate.aggregate(aggregation, "weatherData",
				WeatherData.class);
		return results.getMappedResults();

	}

	@Override
	public List<WeatherData> findHourlyAveWeatherByCity(String city) {
		ProjectionOperation project = Aggregation.project("_id", "city", "pressure", "temperature", "humidity")
				.andExpression("dayOfYear(timestamp)").as("day").andExpression("hour(timestamp)").as("hour");
		MatchOperation match = Aggregation.match(Criteria.where("city").is(city.toLowerCase()));
		GroupOperation groupByDayOfYear = Aggregation.group("day", "hour");
		Aggregation aggregation = Aggregation.newAggregation(project, match, groupByDayOfYear.addToSet("_id").as("id")
				.avg("pressure").as("pressure").avg("temperature").as("temperature").avg("humidity").as("humidity"));
		AggregationResults<WeatherData> results = mongoTemplate.aggregate(aggregation, "weatherData",
				WeatherData.class);
		return results.getMappedResults();
	}

}
