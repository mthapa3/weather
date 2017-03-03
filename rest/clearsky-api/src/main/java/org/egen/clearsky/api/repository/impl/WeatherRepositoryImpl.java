package org.egen.clearsky.api.repository.impl;

import java.util.List;

import org.egen.clearsky.api.entity.WeatherData;
import org.egen.clearsky.api.repository.WeatherRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

public class WeatherRepositoryImpl implements WeatherRepositoryCustom {

	private final MongoTemplate mongoTemplate;

	public WeatherRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	// private MatchOperation getMatchOperation(String city) {
	// Criteria cityCriteria = where("city").;
	// return match(cityCriteria);
	// }
	//
	// private GroupOperation getGroupOperation() {
	// return group("timestamp")
	// .last("warehouse").as("warehouse")
	// .addToSet("id").as("productIds")
	// .avg("price").as("averagePrice")
	// .sum("price").as("totalRevenue");
	// }
}
