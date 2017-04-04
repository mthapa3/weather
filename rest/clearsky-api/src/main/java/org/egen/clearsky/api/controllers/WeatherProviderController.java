package org.egen.clearsky.api.controllers;

import java.util.List;

import org.egen.clearsky.api.constants.URI;
import org.egen.clearsky.api.entity.WeatherData;
import org.egen.clearsky.api.service.WeatherProviderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.CITIES)
@Api(tags = "weatherProvider")
public class WeatherProviderController {

	private WeatherProviderService weatherProviderService;

	public WeatherProviderController(WeatherProviderService weatherProviderService) {
		this.weatherProviderService = weatherProviderService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "find the list of cities that have ever reported their weather in the past", notes = "Returns a list of cities in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<String> findAll() {
		return weatherProviderService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY)
	@ApiOperation(value = "find the latest weather for a city", notes = "Returns latest weather data for the given city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherData findWeatherByCity(@PathVariable("city") String city) {
		return weatherProviderService.findWeatherByCity(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY + '/' + URI.PROPERTY)
	@ApiOperation(value = "find the latest property of weather for city", notes = "Returns weather property for the given city.\n"
			+ "values : " + URI.DESCRIPTION + " , " + URI.HUMIDITY + " , " + URI.PRESSURE + " , " + URI.TEMPERATURE
			+ " , " + URI.WIND)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findPropertyByCity(@PathVariable("city") String city, @PathVariable("property") String property) {
		return weatherProviderService.findPropertyByCity(property, city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY + '/' + URI.AVERAGE + '/' + URI.DAILY)
	@ApiOperation(value = "find the daily average weather for city", notes = "Returns a list of daily averaged weather for the given city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<WeatherData> findDailyAveWeatherByCity(@PathVariable("city") String city) {
		return weatherProviderService.findDailyAveWeatherByCity(city);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY + '/' + URI.AVERAGE + '/' + URI.HOURLY)
	@ApiOperation(value = "find the hourly average weather for city", notes = "Returns a list of hourly averaged weather for the given city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<WeatherData> findHourlyAveWeatherByCity(@PathVariable("city") String city) {
		return weatherProviderService.findHourlyAveWeatherByCity(city);
	}
}
