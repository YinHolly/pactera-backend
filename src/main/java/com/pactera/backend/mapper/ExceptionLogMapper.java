package com.pactera.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.pactera.backend.dto.ExceptionLogDto;

/**
 * 
 * @interface: ExceptionLogMapper
 * @author Holly.y.yin
 * @date 2021/06/01
 *
 */
@Repository
public interface ExceptionLogMapper {

	@Insert("insert into exception_log(message,time) value(#{message}, #{time})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void saveExceptionLog(ExceptionLogDto exceptionLogDto);
	
	

}
