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
	private ClientTO clientTO;
	private CarTO carTO;
	private OfficeTO rentOfficeTO;
	private Date rentDate;
	private OfficeTO returnOfficeTO;
	private Date returnDate;
	private long price;

}
