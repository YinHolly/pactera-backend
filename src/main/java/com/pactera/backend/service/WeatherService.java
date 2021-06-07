package com.pactera.backend.service;

import com.pactera.backend.dto.WeatherAPIInfoDto;
import com.pactera.backend.dto.WeatherInfoDto;

/**
 *@author Holly.Y.Yin
 *
 */
public interface WeatherService {

	WeatherInfoDto getWeatherInfo(WeatherAPIInfoDto weatherAPIInfoDto);

}
