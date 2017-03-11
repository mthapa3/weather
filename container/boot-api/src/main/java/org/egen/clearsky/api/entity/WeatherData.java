package org.egen.clearsky.api.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "weatherData")
@CompoundIndexes({ @CompoundIndex(name = "city_time_idx", def = "{'city': 1, 'timestamp': -1}") })
public class WeatherData {

	@Id
	private String id;
	private String city;
	private float temperature;
	private float pressure;
	private float humidity;
	private Wind wind;
	private String description;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public WeatherData() {
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", city=" + city + ", temperature=" + temperature + ", pressure=" + pressure
				+ ", humidity=" + humidity + ", wind=" + wind + ", description=" + description + ", timestamp="
				+ timestamp + "]";
	}

}
