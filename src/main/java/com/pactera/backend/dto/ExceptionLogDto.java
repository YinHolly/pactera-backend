 package com.pactera.backend.dto;

import java.util.Date;

import lombok.Data;

@Data
 public class ExceptionLogDto {

	private Integer id;

    private String message;

	private Date time;
	 
	 
}
