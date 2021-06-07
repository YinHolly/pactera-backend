package com.pactera.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pactera.backend.common.JsonResult;
import com.pactera.backend.dto.WeatherAPIInfoDto;
import com.pactera.backend.dto.WeatherInfoDto;
import com.pactera.backend.exception.service.ExceptionLogService;
import com.pactera.backend.service.WeatherService;

/**
 * @author Holly.Y.Yin
 *
 */
@RestController
@RequestMapping("weatherAPI")
@CrossOrigin
public class WeatherController {

	@Value("${weather.api.url}")
	private String weatherApiUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private ExceptionLogService exceptionLogService;

	@RequestMapping("/getWehtherInfo")
	public JsonResult<WeatherInfoDto> getWehtherInfo(String city) {

		try {
			StringBuilder weatherUrl = new StringBuilder(weatherApiUrl);
			weatherUrl.append(city);
			WeatherAPIInfoDto weatherAPIInfoDto = restTemplate.getForObject(weatherUrl.toString(),
					WeatherAPIInfoDto.class);
			if (weatherAPIInfoDto != null) {
				return JsonResult.ok(weatherService.getWeatherInfo(weatherAPIInfoDto));
			}
			

		} catch (Exception e) {

			exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());

		}
		return null;

	}

}
