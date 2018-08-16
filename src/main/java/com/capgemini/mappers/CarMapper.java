package com.capgemini.mappers;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;

public class CarMapper {

	public static CarTO map2TO(CarEntity carEntity){
		CarTO carTO = new CarTO();
		carTO.setId(carEntity.getId());
		carTO.setBrand(carEntity.getBrand());
		carTO.setModel(carEntity.getModel());
		carTO.setType(carEntity.getType());
		carTO.setColor(carEntity.getColor());
		carTO.setYear(carEntity.getYear());
		carTO.setEngineCapacity(carEntity.getEngineCapacity());
		carTO.setEngineForce(carEntity.getEngineForce());
		carTO.setMileage(carEntity.getMileage());
		return carTO;
	}
	
	public static CarEntity map2Entity(CarTO carTO){
		return map2Entity(carTO, new CarEntity());

	}
	
	public static List<CarTO> map2TOs(List<CarEntity> carEntities){
		List<CarTO> carTOs = new LinkedList<>();
		for (CarEntity carEntity : carEntities) {
			CarTO carTO = map2TO(carEntity);
			carTOs.add(carTO);
		}
		return carTOs;
	}
	
	public static List<CarEntity> map2Entities(List<CarTO> carTOs ){
		List<CarEntity> carEntities = new LinkedList<>();
		for (CarTO carTO : carTOs) {
			CarEntity carEntity = map2Entity(carTO);
			carEntities.add(carEntity);
		}
		return carEntities;
	}

	public static CarEntity map2Entity(CarTO carTO, CarEntity carEntity) {
		carEntity.setId(carTO.getId());
		carEntity.setBrand(carTO.getBrand());
		carEntity.setModel(carTO.getModel());
		carEntity.setType(carTO.getType());
		carEntity.setColor(carTO.getColor());
		carEntity.setYear(carTO.getYear());
		carEntity.setEngineCapacity(carTO.getEngineCapacity());
		carEntity.setEngineForce(carTO.getEngineForce());
		carEntity.setMileage(carTO.getMileage());
		return carEntity;
	}
}
