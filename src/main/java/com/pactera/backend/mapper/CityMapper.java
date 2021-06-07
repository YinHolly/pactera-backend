package com.pactera.backend.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.pactera.backend.dto.CityDto;


public interface CityMapper {

	@Select("select * from city")
	List<CityDto> getCityList();

}
