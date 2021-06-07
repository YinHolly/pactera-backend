package com.pactera.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class OwnerDto {

	private String name;
	private String gender;
	private Integer age;
	private List<PetDto> pets;

}
