package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "CAR")
public class CarEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4301431497087237112L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "BRAND", nullable = false, length = 50)
	private String brand;
	@Column(name = "MODEL", nullable = false, length = 50)
	private String model;
	@Column(name = "TYPE", nullable = false, length = 50)
	private String type;
	@Column(name = "YEAR", nullable = false, length = 50)
	private int year;
	@Column(name = "COLOR", nullable = false, length = 50)
	private String color;
	@Column(name = "ENGINE_CAPACITY", nullable = false, length = 50)
	private int engineCapacity;
	@Column(name = "ENGINE_FORCE", nullable = false, length = 50)
	private int engineForce;
	@Column(name = "MILEAGE", nullable = false, length = 50)
	private int mileage;
	@ManyToMany(mappedBy = "cars")
	private List<EmployeeEntity> employies = new LinkedList<>();
	@OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
	private List<RentEntity> rents;
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

	public void addEmployee(EmployeeEntity employeeEntity) {
		employies.add(employeeEntity);
	}

}