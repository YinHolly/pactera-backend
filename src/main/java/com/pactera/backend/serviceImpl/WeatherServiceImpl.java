/**
 * 
 */
package com.pactera.backend.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.pactera.backend.dto.WeatherAPIInfoDto;
import com.pactera.backend.dto.WeatherInfoDto;
import com.pactera.backend.service.WeatherService;
import com.pactera.backend.util.ConstantsUtil;

/**
 * @author Holly
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	/**
	 * 
	 * <p>
	 * Title: getWeatherInfo
	 * </p>
	 * <p>
	 * Description: Retrieve the current weather info
	 * </p>
	 * 
	 * @param weatherAPIInfoDto
	 * @return WeatherInfoDto
	 */
	@Override
	public WeatherInfoDto getWeatherInfo(WeatherAPIInfoDto weatherAPIInfoDto) {
		WeatherInfoDto weatherInfoDto = new WeatherInfoDto();
		weatherInfoDto.setCity(weatherAPIInfoDto.getName());
		SimpleDateFormat sdf = new SimpleDateFormat(ConstantsUtil.DATE_FOMRAT, Locale.ENGLISH);
		weatherInfoDto.setUpdateTime(sdf.format(new Date()));
		if (weatherAPIInfoDto.getWeather() != null) {
			weatherInfoDto.setWeather(weatherAPIInfoDto.getWeather().get(0).getDescription());
		}
		if (weatherAPIInfoDto.getMain() != null && weatherAPIInfoDto.getMain() != null) {
			weatherInfoDto.setTemperature(weatherAPIInfoDto.getMain().getTemp() + ConstantsUtil.TEMPRATURE_UNIT);
		}
		if (weatherAPIInfoDto.getWind() != null && weatherAPIInfoDto.getWind().getSpeed() != null) {
			weatherInfoDto.setWind(weatherAPIInfoDto.getWind().getSpeed() + ConstantsUtil.WIND_SPEED_UNIT);
		}
		return weatherInfoDto;
	}
}
