package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.criteria.Order;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer customerId;
	
	@NotBlank(message = "name Should not be blanck")
	private String firstName;
	
	private String lastName;
	
	@Past(message = "date of birth can not be future")
	private LocalDate dob;
	
	@Embedded
	@Valid
	private Address address;
	
	@NotBlank(message = "Mobile number can not be blanck")
	@Min(value = 10,message = "mobile number can not be less then 10 digit")
	@Max(value = 10,message = "mobile number can not be greater then 10 digit")
	private String mobileNo;
	
	@Email(message = "Email should be in right formate")
	private String email;
	
	
	@Min(value = 6,message = "password can not be less then 6 charector")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;
	
	@OneToMany
	private List<Order> order=new ArrayList<>();
	
	private String enteredDate;
	
}
