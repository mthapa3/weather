package org.egen.clearsky.api.controllers;

import org.egen.clearsky.api.constants.URI;
import org.egen.clearsky.api.entity.WeatherData;
import org.egen.clearsky.api.service.IOTWeatherConsumerService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(value = URI.WEATHER)
@Api(tags = "IOTWeatherConsumer")
public class IOTWeatherConsumerController {

	private IOTWeatherConsumerService iOTWeatherConsumerService;

	public IOTWeatherConsumerController(IOTWeatherConsumerService iOTWeatherConsumerService) {
		this.iOTWeatherConsumerService = iOTWeatherConsumerService;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "consume the latest weather data")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	// validation to be added
	public void submitWeatherData(@RequestBody WeatherData data) {
		iOTWeatherConsumerService.submitWeatherData(data);
	}

}
