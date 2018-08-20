package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.EmployeeEntity;
import com.capgemini.types.CarTO;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.OfficeTO;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeServiceTest {
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CarService carService;
	
	@Test
	public void testShouldAddOffice() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		

		// when
		OfficeTO selectedOffice = officeService.getOffice(1L);

		// then
		assertNotNull(selectedOffice);
		assertEquals(addedOffice.getCity(), selectedOffice.getCity());
	}
	
	@Test
	public void testShouldAddOffices() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		

		// when
		OfficeTO selectedOffice2 = officeService.getOffice(2L);
		OfficeTO selectedOffice3 = officeService.getOffice(3L);
		OfficeTO selectedOffice4 = officeService.getOffice(4L);

		// then
		assertNotNull(selectedOffice2);
		assertNotNull(selectedOffice3);
		assertNotNull(selectedOffice4);
		assertEquals(addedOffice2.getCity(), selectedOffice2.getCity());
		assertEquals(addedOffice3.getCity(), selectedOffice3.getCity());
		assertEquals(addedOffice4.getCity(), selectedOffice4.getCity());
	}
	
	@Test
	public void testShouldDeleteOffice() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		

		// when
		officeTO.setId(1L);
		officeService.deleteOffice(officeTO);
		


		// then
		assertEquals(officeService.getAllOffices().size(), 3);

	}
	
	@Test
	public void testShouldUpdateOffices() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		addedOffice.setCity("Gdansk");

		// when
		OfficeTO updatedOffice = officeService.updateOffice(addedOffice);
		OfficeTO selectedOffice = officeService.getOffice(updatedOffice.getId());

		// then
		assertNotNull(selectedOffice);
		assertEquals(updatedOffice.getCity(), selectedOffice.getCity());
		assertEquals(updatedOffice.getCity(), "Gdansk");
	}

	@Test
	public void testShouldAddEmployee() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		EmployeeTO ee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO ee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));

		// when
		List<EmployeeTO> employies = officeService.addEmployeeToOffice(addedOffice, ee1);
		List<EmployeeTO> employies2 = officeService.addEmployeeToOffice(addedOffice, ee2);
		

		// then
		assertNotNull(employies);
		assertNotNull(employies2);
		assertEquals(1, employies.size());
		assertEquals(2, employies2.size());
	}
	
	@Test
	public void testShouldRemoveEmployee() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		EmployeeTO ee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO ee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));

		// when
		List<EmployeeTO> employies = officeService.addEmployeeToOffice(addedOffice, ee1);
		List<EmployeeTO> employies2 = officeService.addEmployeeToOffice(addedOffice2, ee2);
		EmployeeTO deletedEmployee = officeService.removeEmployeeFromOffice(addedOffice, ee1);

		// then
		assertNotNull(employies);
		assertNotNull(employies2);
		assertNotNull(deletedEmployee);
		assertEquals(1, employies.size());
		assertEquals(1, employies2.size());
		assertEquals("firstName", deletedEmployee.getFirstName());
	}
	
	
	@Test
	public void testShouldGetEmployies() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		EmployeeTO ee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO ee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));

		// when
		List<EmployeeTO> employies = officeService.addEmployeeToOffice(addedOffice, ee1);
		int employiesAmount = officeService.getAllOfficeEmployies(addedOffice).size();

		// then
		assertNotNull(employiesAmount);
		assertEquals(1, employiesAmount);
		assertEquals(1, employies.size());
	}
	
	@Test
	public void testShouldGetEmployiesByCar() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		EmployeeTO ee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO ee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));
		
		CarTO carTO = CarTO.builder()
				.brand("Toyota")
				.model("Rav4")
				.color("pink")
				.type("SUV")
				.engineCapacity(2000)
				.engineForce(120).year(2016).mileage(1000).build();
		CarTO addedCar = carService.addCar(carTO);
		
		List<EmployeeTO> addedEmpl = officeService.addEmployeeToOffice(addedOffice, ee1);
		carService.setEmployee(addedCar, ee1);

		// when
		List<EmployeeTO> employies = officeService.addEmployeeToOffice(addedOffice, ee1);
		List<EmployeeTO> eEntities = officeService.getOfficeEmployiesByCar(addedOffice, addedCar);

		// then
		assertNotNull(eEntities);
		assertEquals(1, eEntities.size());
	}
	
	@Test
	public void testShouldGetEmployiesByPosition() {

		// given
		OfficeTO officeTO = OfficeTO.builder().city("Poznań").address("Kolorowa 1").email("poznan@carrent.pl").phone(555444333).build();
		OfficeTO addedOffice = officeService.addOffice(officeTO);
		OfficeTO officeTO2 = OfficeTO.builder().city("Warszawa").address("Zielona 1").email("warszawa@carrent.pl").phone(455444333).build();
		OfficeTO addedOffice2 = officeService.addOffice(officeTO2);
		OfficeTO officeTO3 = OfficeTO.builder().city("Lodz").address("Klorowa 1").email("lodz@carrent.pl").phone(355444333).build();
		OfficeTO addedOffice3 = officeService.addOffice(officeTO3);
		OfficeTO officeTO4 = OfficeTO.builder().city("Wroclaw").address("Korowa 1").email("wroclaw@carrent.pl").phone(255444333).build();
		OfficeTO addedOffice4 = officeService.addOffice(officeTO4);
		EmployeeTO ee1 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName", "lastName", "position", 44));
		EmployeeTO ee2 = employeeService.addEmployee(
				new EmployeeTO(null, "firstName2", "lastName2", "position", 32));

		// when
		List<EmployeeTO> employies = employeeService.getEmployiesByPosition("position");
		

		// then
		assertNotNull(employies);
		assertEquals(2, employies.size());
	}
	
}

