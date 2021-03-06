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
@Table(name = "CLIENT")
public class ClientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1997103148119427026L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "FIRST_NAME", nullable = true, length = 50)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String lastName;
	@Column(name = "EMAIL", nullable = true, length = 50)
	private String email;
	@Column(name = "DAT_OF_BIRTH", nullable = true, length = 50)
	private Date dateOfBirth;
	@Column(name = "ADDRESS", nullable = true, length = 50)
	private String addres;
	@Column(name = "PHONE", nullable = true, length = 50)
	private String phone;
	@Column(name = "CREDIT_CARD", nullable = true, length = 50)
	private long creditCard;
	@OneToMany(mappedBy = "client")
	private List<RentEntity> rents = new LinkedList<>();
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	@Version
	private Long version;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
}
