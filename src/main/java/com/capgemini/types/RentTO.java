package com.capgemini.types;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentTO {
	
	private long id;
	private long clientId;
	private long carId;
	private long rentOfficeId;
	private Date rentDate;
	private long returnOfficeId;
	private Date returnDate;
	private long price;

}
