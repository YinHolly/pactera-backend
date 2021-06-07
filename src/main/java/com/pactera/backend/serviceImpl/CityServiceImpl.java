package com.pactera.backend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.backend.dto.CityDto;
import com.pactera.backend.mapper.CityMapper;
import com.pactera.backend.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<CityDto> getCityList() {
		List<CityDto> cityList = null;
		cityList = cityMapper.getCityList();
		return cityList;
	}

}
