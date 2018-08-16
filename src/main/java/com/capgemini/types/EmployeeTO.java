package com.capgemini.types;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.OfficeEntity;

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
