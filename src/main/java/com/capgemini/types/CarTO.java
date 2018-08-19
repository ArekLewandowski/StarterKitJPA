package com.capgemini.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class CarTO {

	private Long id;
	private String brand;
	private String model;
	private String type;
	private int year;
	private String color;
	private int engineCapacity;
	private int engineForce;
	private int mileage;
}
