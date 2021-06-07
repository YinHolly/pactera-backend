package com.pactera.backend.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pactera.backend.dto.OwnerDto;
import com.pactera.backend.dto.PetDto;
import com.pactera.backend.service.PetsService;
import com.pactera.backend.util.ConstantsUtil;

@Service
public class PetsServiceImpl implements PetsService {

	/**
	 * 
	 * <p>
	 * Title: getCatsList
	 * </p>
	 * <p>
	 * Description: Output a list of all the cats in alphabetical order under a
	 * heading of the gender of their owners
	 * </p>
	 * 
	 * @param ownerList
	 * @return
	 */
	@Override
	public Map<String, List<PetDto>> getCatsList(OwnerDto[] ownerList) {

		Map<String, List<PetDto>> catsMap = new HashMap<>();
		List<PetDto> maleCatsList = new ArrayList<>();
		List<PetDto> femaleCatsList = new ArrayList<>();
		for (OwnerDto ownerDto : ownerList) {

			if (ownerDto.getPets() != null && !ownerDto.getPets().isEmpty()) {
				for (PetDto petDto : ownerDto.getPets()) {
					if (ConstantsUtil.CAT.equalsIgnoreCase(petDto.getType())
							&& ConstantsUtil.FEMALE.equalsIgnoreCase(ownerDto.getGender())) {
						femaleCatsList.add(petDto);

					}
					if (ConstantsUtil.CAT.equalsIgnoreCase(petDto.getType())
							&& ConstantsUtil.MALE.equalsIgnoreCase(ownerDto.getGender())) {
						maleCatsList.add(petDto);
					}
				}

			}

//			all the cats in alphabetical order
			if (!femaleCatsList.isEmpty()) {
				Collections.sort(femaleCatsList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
				catsMap.put(ConstantsUtil.FEMALE, femaleCatsList);
			}
			if (!maleCatsList.isEmpty()) {
				Collections.sort(maleCatsList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
				catsMap.put(ConstantsUtil.MALE, maleCatsList);
			}

		}

		return catsMap;
	}

}
