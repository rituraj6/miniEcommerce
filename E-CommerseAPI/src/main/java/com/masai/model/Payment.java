package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer paymentId;
		
		@NotBlank(message = "payment type can't be blank")
		private String paymentType;
		
		@NotBlank(message = "allowed section can't be blank")
		private String allowed;
}
