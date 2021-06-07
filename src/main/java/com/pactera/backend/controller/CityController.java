package com.pactera.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactera.backend.common.JsonResult;
import com.pactera.backend.dto.CityDto;
import com.pactera.backend.exception.service.ExceptionLogService;
import com.pactera.backend.service.CityService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Holly.Y.Yin
 *
 */
@RestController
@RequestMapping("city")
@CrossOrigin
public class CityController {

	@Autowired
	private CityService cityService;
	@Autowired
	private ExceptionLogService exceptionLogService;

	@RequestMapping("/getCityList")
	@ApiOperation(value = "get all cities", notes = "It's used to display all cities")
	public JsonResult<List<CityDto>> getCityList() {
		List<CityDto> cityList = null;

		try {
			cityList = cityService.getCityList();
		} catch (Exception e) {
			exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok(cityList);
	}

}
