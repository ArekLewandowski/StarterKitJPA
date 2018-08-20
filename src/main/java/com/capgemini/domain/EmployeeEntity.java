package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6832813275391822250L;
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String lastName;
	@Column(name = "POSITION", nullable = false, length = 50)
	private String position;
	@Column(name = "AGE", nullable = false, length = 50)
	private int age;
	@ManyToOne
	OfficeEntity office;
	@ManyToMany
	@JoinTable(name = "CAR_EMPLOYEE", joinColumns = {
			@JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CAR_ID", nullable = false, updatable = false) })
	private List<CarEntity> cars = new LinkedList<>();
	@Version
	private Long version;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public void addCar(CarEntity car) {
		cars.add(car);
	}
}
