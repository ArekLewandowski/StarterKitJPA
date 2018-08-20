package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "RENT")
public class RentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6200182743822929884L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	ClientEntity client;
	@ManyToOne
	CarEntity car;
	@ManyToOne
	OfficeEntity rentOffice;
	@Column(name = "RENT_DATE")
	private Date rentDate;
	@ManyToOne
	OfficeEntity returnOffice;
	@Column(name = "RETURN_DATE")
	private Date returnDate;
	@Column
	private long price;
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
}
