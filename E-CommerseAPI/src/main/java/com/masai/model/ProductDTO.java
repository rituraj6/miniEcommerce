package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private Integer productId;
	private String productName;
	private Integer salePrice;
	private Integer marketPrice;
	private String Brand;
	private Integer quantity;

}
