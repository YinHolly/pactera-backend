package com.pactera.backend.service;

import java.util.List;
import java.util.Map;

import com.pactera.backend.dto.OwnerDto;
import com.pactera.backend.dto.PetDto;

public interface PetsService {

	Map<String, List<PetDto>> getCatsList(OwnerDto[] ownerList);

}
