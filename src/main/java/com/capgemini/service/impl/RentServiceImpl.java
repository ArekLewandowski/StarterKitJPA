package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CarDAO;
import com.capgemini.dao.ClientDAO;
import com.capgemini.dao.OfficeDAO;
import com.capgemini.dao.RentDAO;
import com.capgemini.dao.impl.CarDaoImpl;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.ClientEntity;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.ClientMapper;
import com.capgemini.mappers.OfficeMapper;
import com.capgemini.mappers.RentMapper;
import com.capgemini.service.RentService;
import com.capgemini.types.CarTO;
import com.capgemini.types.RentTO;

@Service
@Transactional
public class RentServiceImpl implements RentService {

	@Autowired
	private RentDAO rentDAO;

	@Autowired
	private CarDAO carDAO;

	@Autowired
	private OfficeDAO officeDAO;

	@Autowired
	private ClientDAO clientDAO;

	@Override
	public RentTO addRent(RentTO rentTO) {
		CarEntity carEntity = carDAO.getOne(rentTO.getCarTO().getId());
		ClientEntity clientEntity = clientDAO.getOne(rentTO.getClientTO().getId());
		OfficeEntity rentOffice = officeDAO.getOne(rentTO.getRentOfficeTO().getId());
		OfficeEntity returnOffice = (rentTO.getReturnOfficeTO() == null) ? null : officeDAO.getOne(rentTO.getReturnOfficeTO().getId());
		RentEntity rentEntity = RentMapper.map2Entity(rentTO);
		rentEntity = RentMapper.fillEntity(rentEntity, carEntity, clientEntity, rentOffice, returnOffice);
		rentEntity = rentDAO.save(rentEntity);
		rentTO = RentMapper.map2TO(rentEntity);
		rentTO.setCarTO(CarMapper.map2TO(rentEntity.getCar()));
		rentTO.setClientTO(ClientMapper.map2TO(rentEntity.getClient()));
		rentTO.setRentOfficeTO(OfficeMapper.map2TO(rentEntity.getRentOffice()));
		rentTO.setReturnOfficeTO(
				(rentEntity.getReturnOffice() == null) ? null : OfficeMapper.map2TO(rentEntity.getReturnOffice()));
		return rentTO;
	}

	@Override
	public RentTO getOne(Long id) {
		RentEntity rentEntity = rentDAO.getOne(id);
		RentTO rentTO = RentMapper.map2TO(rentEntity);
		rentTO.setCarTO(CarMapper.map2TO(rentEntity.getCar()));
		rentTO.setClientTO(ClientMapper.map2TO(rentEntity.getClient()));
		rentTO.setRentOfficeTO(OfficeMapper.map2TO(rentEntity.getRentOffice()));
		rentTO.setReturnOfficeTO(
				(rentEntity.getReturnOffice() == null) ? null : OfficeMapper.map2TO(rentEntity.getReturnOffice()));
		return rentTO;
	}

	@Override
	public List<CarTO> getCarsRentedMoreThanXTimes(long times) {
		List<CarEntity> carEntities = rentDAO.carsRentedMoreThan(times);
		List<CarTO> carTOs = CarMapper.map2TOs(carEntities);
		return carTOs;
	}

	@Override
	public Long countRentedCars(Date startDateTime, Date endtDateTime) {
		Long count = rentDAO.countRentedCars(startDateTime, endtDateTime);
		return count;
	}

}
