package com.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "OFFICE")
public class OfficeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 483832167731885683L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String city;
	@Column(nullable = false, length = 50)
	private String address;
	@Column(nullable = true, length = 50)
	private String email;
	@Column(nullable = true, length = 50)
	private int phone;
	@OneToMany(mappedBy = "office")
	private List<EmployeeEntity> employies = new ArrayList<>();
	@OneToMany(mappedBy = "rentOffice")
	private List<RentEntity> rents;
	@OneToMany(mappedBy = "returnOffice")
	private List<RentEntity> returns;
	
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
	
	public void addEmployee(EmployeeEntity employeeEntity){
		employies.add(employeeEntity);
	}
}
