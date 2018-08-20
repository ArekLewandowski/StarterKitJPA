package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CarDAO;
import com.capgemini.dao.EmployeeDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	CarDAO carDAO;

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public CarTO addCar(CarTO car) {
		CarEntity carEntity = CarMapper.map2Entity(car);
		carEntity = carDAO.save(carEntity);
		car = CarMapper.map2TO(carEntity);
		System.out.println("Creation time........." + carEntity.getCreateDate());
		System.out.println("Update time........." + carEntity.getModifyDate());
		return car;
	}

	@Override
	public CarTO deleteCar(CarTO car) {
		carDAO.delete(CarMapper.map2Entity(car));
		return car;
	}

	@Override
	public void deleteCar(Long id) {
		carDAO.delete(id);
	}

	@Override
	public CarTO updateCar(CarTO car) {
		CarEntity carEntity = carDAO.findOne(car.getId());
		carDAO.update(CarMapper.map2Entity(car, carEntity));
		return car;
	}

	@Override
	public CarTO setEmployee(CarTO car, EmployeeTO employee) {
		CarEntity cEntity = carDAO.getOne(car.getId());
		EmployeeEntity eEntity = employeeDAO.getOne(employee.getId());
		carDAO.addEmployee(cEntity, eEntity);
		return car;
	}

	@Override
	public List<CarTO> getCarByType(String type) {
		List<CarTO> cars = CarMapper.map2TOs(carDAO.getByType(type));
		return cars;
	}

	@Override
	public List<CarTO> getCarByBrand(String brand) {
		List<CarTO> cars = CarMapper.map2TOs(carDAO.getByBrand(brand));
		return cars;
	}

	@Override
	public List<CarTO> getCarByEmployee(EmployeeTO employee) {
		List<CarTO> cars = CarMapper.map2TOs(employeeDAO.getOne(employee.getId()).getCars());
		return cars;
	}

	@Override
	public CarTO getCar(Long id) {
		CarTO carTO = CarMapper.map2TO(carDAO.getOne(id));
		return carTO;
	}

	@Override
	public List<CarTO> getAllCars() {
		List<CarTO> carTOs = CarMapper.map2TOs(carDAO.findAll());
		return carTOs;
	}

}
