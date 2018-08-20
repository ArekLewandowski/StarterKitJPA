package com.capgemini.mappers;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.domain.OfficeEntity;
import com.capgemini.types.OfficeTO;

public class OfficeMapper {

	public static OfficeTO map2TO(OfficeEntity officeEntity) {
		OfficeTO officeTO = new OfficeTO();
		officeTO.setId(officeEntity.getId());
		officeTO.setCity(officeEntity.getCity());
		officeTO.setAddress(officeEntity.getAddress());
		officeTO.setEmail(officeEntity.getEmail());
		officeTO.setPhone(officeEntity.getPhone());
		return officeTO;
	}

	public static OfficeEntity map2Entity(OfficeTO officeTO) {
		return map2Entity(officeTO, new OfficeEntity());
	}

	public static OfficeEntity map2Entity(OfficeTO officeTO, OfficeEntity officeEntity) {
		officeEntity.setId(officeTO.getId());
		officeEntity.setCity(officeTO.getCity());
		officeEntity.setAddress(officeTO.getAddress());
		officeEntity.setEmail(officeTO.getEmail());
		officeEntity.setPhone(officeTO.getPhone());
		return officeEntity;
	}

	public static List<OfficeTO> map2TOs(List<OfficeEntity> officeEntities) {
		List<OfficeTO> officeTOs = new LinkedList<>();
		for (OfficeEntity officeEntity : officeEntities) {
			OfficeTO officeTO = map2TO(officeEntity);
			officeTOs.add(officeTO);
		}
		return officeTOs;
	}

	public static List<OfficeEntity> map2Entities(List<OfficeTO> officeTOs) {
		List<OfficeEntity> officeEntities = new LinkedList<>();
		for (OfficeTO officeTO : officeTOs) {
			OfficeEntity officeEntity = map2Entity(officeTO);
			officeEntities.add(officeEntity);
		}
		return officeEntities;
	}
}