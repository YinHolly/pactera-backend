package com.pactera.backend.exception.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.backend.dto.ExceptionLogDto;
import com.pactera.backend.exception.service.ExceptionLogService;
import com.pactera.backend.mapper.ExceptionLogMapper;

/**
 * @author Holly.Y.Yin
 *
 */
@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

	@Autowired
	private ExceptionLogMapper exceptionLogMapper;

	@Override
	public void addExceptionLog(Exception e) {
		ExceptionLogDto exceptionLogEntity = new ExceptionLogDto();
		exceptionLogEntity.setMessage(getExceptionStaclTrace(e));
		exceptionLogEntity.setTime(new Date());
		exceptionLogMapper.saveExceptionLog(exceptionLogEntity);
	}

	private String getExceptionStaclTrace(Exception e) {
		e.printStackTrace();
		return e.getLocalizedMessage();
	}
}
