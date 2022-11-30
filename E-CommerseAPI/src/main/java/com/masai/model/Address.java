package com.masai.model;

import javax.validation.constraints.NotBlank;

public class Address {
	
	@NotBlank(message = "city can not be blanck")
	private String city;
	
	@NotBlank(message = "satate can not be blanck")
	private String state;
	
	@NotBlank(message = "country can not be blanck")
	private String country;
	
	@NotBlank(message = "pinCode can not be blanck")
	private String postalCode;
	
	

}
