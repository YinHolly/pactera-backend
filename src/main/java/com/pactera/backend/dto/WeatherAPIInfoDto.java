package com.pactera.backend.dto;

import java.util.List;

import lombok.Data;

/**
 * @author Holly.Y.Yin
 *
 */
@Data
public class WeatherAPIInfoDto {
	private String name;
	private List<WeatherDto> weather;
	private MainDto main;
	private WindDto wind;

}
