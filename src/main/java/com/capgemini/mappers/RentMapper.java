package com.capgemini.mappers;

import com.capgemini.domain.RentEntity;
import com.capgemini.types.RentTO;

public class RentMapper {

	public static RentTO map2TO(RentEntity rentEntity){
		RentTO rentTO = new RentTO();
		rentTO.setId(rentEntity.getId());
		rentTO.setCarId(rentEntity.getCar().getId());
		rentTO.setClientId(rentEntity.getClient().getId());
		rentTO.setRentOfficeId(rentEntity.getRentOffice().getId());
		rentTO.setReturnOfficeId(rentEntity.getReturnOffice().getId());
		rentTO.setRentDate(rentEntity.getRentDate());
		rentTO.setReturnDate(rentEntity.getReturnDate());
		return rentTO;
	}
	
}
