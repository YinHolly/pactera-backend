package com.pactera.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pactera.backend.common.JsonResult;
import com.pactera.backend.dto.OwnerDto;
import com.pactera.backend.dto.PetDto;
import com.pactera.backend.exception.service.ExceptionLogService;
import com.pactera.backend.service.PetsService;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("petsApi")
@CrossOrigin
public class PetsController {

	@Value("${pets.api.url}")
	private String petsApiUrl;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PetsService petsService;

	@Autowired
	private ExceptionLogService exceptionLogService;

	@GetMapping("/getCatsList" )
	@ApiOperation(value = "get the cat list interface", notes = "It's used to output a list of all the cats in alphabetical order under a heading of the gender of their owners for json")
	public JsonResult<Map<String, List<PetDto>>> getCatsList() {
		try {
			OwnerDto[] body = restTemplate.getForObject(petsApiUrl, OwnerDto[].class);
			if (body != null && body.length > 0) {
				return JsonResult.ok(petsService.getCatsList(body));
			}
			return null;
		} catch (Exception e) {
			exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());
		}
	}



}
