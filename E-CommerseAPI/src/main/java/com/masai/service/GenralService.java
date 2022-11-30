package com.masai.service;

import java.util.List;

import com.masai.exception.CategoryException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;

public interface GenralService {
	

	public List<Product> findAll() throws ProductException;
	public Category findCategory(Integer id) throws ProductException;
	public List<Product> searchProduct(String name) throws ProductException;
	public Product viewProduct(Integer id) throws ProductException;
	public List<Product> filterByPrice(Integer firstPrice ,Integer secondPrice) throws ProductException;
	public List<Product> filterByRating(Double rating) throws ProductException;
	public List<Product> filterByPriceOnCategory(Integer firstPrice ,Integer secondPrice,Integer id) throws ProductException;
	public List<Product> filterByRatingOnCategory(Double rating,Integer id) throws ProductException,CategoryException;
	public List<Product> sortByAscending()throws ProductException;
	public List<Product> sortByDescending() throws ProductException;
	public List<Product> sortByAscendingOnRating()throws ProductException;
	public List<Product> sortByDescendingOnRating() throws ProductException;
	public List<Product> sortByAscendingOnCategory(Integer id)throws ProductException,CategoryException;
	public List<Product> sortByDescendingOnCategory(Integer id) throws ProductException,CategoryException;
	public List<Product> sortByAscendingOnRatingInCategory(Integer id)throws ProductException,CategoryException;
	public List<Product> sortByDescendingOnRatingInCategory(Integer id) throws ProductException,CategoryException;
	
	

}
