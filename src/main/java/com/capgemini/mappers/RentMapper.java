package com.capgemini.mappers;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.ClientEntity;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.types.RentTO;

public class RentMapper {

	public static RentTO map2TO(RentEntity rentEntity) {
		RentTO rentTO = new RentTO();
		rentTO.setId(rentEntity.getId());
		rentTO.setRentDate(rentEntity.getRentDate());
		rentTO.setReturnDate((rentEntity.getReturnDate() == null) ? null : rentEntity.getReturnDate());
		rentTO.setPrice(rentEntity.getPrice());
		return rentTO;
	}

	public static RentEntity map2Entity(RentTO rentTO, RentEntity rentEntity) {
		rentEntity.setRentDate(rentTO.getRentDate());
		rentEntity.setReturnDate((rentTO.getReturnOfficeTO() == null) ? null : rentTO.getReturnDate());
		rentEntity.setPrice(rentTO.getPrice());
		return rentEntity;
	}

	public static RentEntity map2Entity(RentTO rentTO) {
		RentEntity rentEntity = new RentEntity();
		return map2Entity(rentTO, rentEntity);
	}

	public static List<RentTO> map2TOs(List<RentEntity> rents) {
		List<RentTO> rentsTO = new LinkedList<>();
		for (RentEntity rentEntity : rents) {
			rentsTO.add(RentMapper.map2TO(rentEntity));
		}
		return rentsTO;
	}

	public static List<RentEntity> map2Entities(List<RentTO> rents) {
		List<RentEntity> rentsEntities = new LinkedList<>();
		for (RentTO rentTO : rents) {
			rentsEntities.add(RentMapper.map2Entity(rentTO));
		}
		return rentsEntities;
	}
	
	public static RentEntity fillEntity(RentEntity rentEntity, CarEntity carEntity, 
			ClientEntity clientEntity, OfficeEntity rentOffice, OfficeEntity returnOffice) {
		rentEntity.setCar(carEntity);
		rentEntity.setClient(clientEntity);
		rentEntity.setRentOffice(rentOffice);
		rentEntity.setReturnOffice(returnOffice);
		return rentEntity;
	}
}
