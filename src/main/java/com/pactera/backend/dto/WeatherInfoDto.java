package com.pactera.backend.dto;

import lombok.Data;

@Data
public class WeatherInfoDto {
	
	private String city;
	private String  updateTime;
	 
	 private String weather;
	 
	 private String temperature;
	 
	 private String wind;

}
