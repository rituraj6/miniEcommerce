package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not be blanck")
	private String productName;
	
	
	@NotNull(message = "productDescription should not be null")
	@NotBlank(message = "productDescription should not be blanck")
	private String productDescription;
	
	
	@Min(value = 10,message = "salePrice should not be less then 10")
	private Integer salePrice;
	
	
	@Min(value = 10,message = "marketPrice should not be less then 10")
	private Integer marketPrice;
	
	@Min(value = 0,message = "rating should not be less then 0")
	@Max(value = 5,message = "rating should not be greater then 5")
	private Double rating;
	
	@NotNull(message = "category should not be null")
	@NotBlank(message = "category should not be blanck")
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	
	@NotNull(message = "brand should not be null")
	@NotBlank(message = "brand should not be blanck")
	private String Brand;
	
	@NotNull(message ="stock can not be null" )
	@JsonIgnore
	private Integer stocks;
	

}
