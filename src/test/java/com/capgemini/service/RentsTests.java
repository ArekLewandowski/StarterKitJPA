package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.ClientDAO;
import com.capgemini.dao.RentDAO;
import com.capgemini.domain.ClientEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.OfficeMapper;
import com.capgemini.types.CarTO;
import com.capgemini.types.OfficeTO;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RentsTests {

	@Autowired
	private RentDAO rentDAO;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Transactional
	@Test
	public void testShouldAddRent() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type("SUV")
				.engineCapacity(2000)
				.engineForce(120)
				.year(2016)
				.mileage(1000)
				.build();
		CarTO updatedCar = carService.addCar(carTO);
		
		CarTO carTO1 = CarTO.builder()
				.brand("Toyota")
				.model("Yaris")
				.color("blue")
				.type("CITY")
				.engineCapacity(1000)
				.engineForce(80)
				.year(2015)
				.mileage(10000)
				.build();
		CarTO updatedCar1 = carService.addCar(carTO1);
		
		CarTO carTO2 = CarTO.builder()
				.brand("Honda")
				.model("Civic")
				.color("black")
				.type("HATCHBACK")
				.engineCapacity(1600)
				.engineForce(100)
				.year(2016)
				.mileage(5000)
				.build();
		CarTO updatedCar2 = carService.addCar(carTO2);
		
		ClientEntity ce = new ClientEntity();
		ce.setFirstName("Stefan");
		ce.setLastName("Nowak");
		ce.setAddres("Poznań");
		ce.setAddres("sn@email.pl");	
		clientDAO.save(ce);
		
		RentEntity rentEntity = new RentEntity();
		rentEntity.setCar(CarMapper.map2Entity(updatedCar));
		rentEntity.setClient(ce);
		rentEntity.setRentOffice(OfficeMapper.map2Entity(addedOffice));
		rentEntity.setRentDate(java.sql.Date.valueOf("2016-01-01"));
		rentEntity.setPrice(1000);
		


		// when
		
		RentEntity savedRent = rentDAO.save(rentEntity);

		// then
		assertNotNull(savedRent);
		assertEquals(CarMapper.map2Entity(updatedCar), rentDAO.getOne(savedRent.getId()).getCar());
	}
}
