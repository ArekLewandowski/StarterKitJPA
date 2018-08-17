package com.capgemini.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String position;
	private int age;

}
