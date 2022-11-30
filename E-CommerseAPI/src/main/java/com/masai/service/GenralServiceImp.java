package com.masai.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.CategoryException;
import com.masai.exception.ProductException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repositry.CategoryRepo;
import com.masai.repositry.ProductRepo;

public class GenralServiceImp implements GenralService {
	
	@Autowired
	ProductRepo pr;
	
	@Autowired
	CategoryRepo category;
	


	@Override
	public List<Product> findAll() throws ProductException {
		List<Product> products=pr.findAll();
		if(products.size()==0) throw new ProductException("Products are not available ");	
		return products;
	}
	
	public Category findCategory(Integer id) throws ProductException{
		Optional<Category> products=category.findById(id);
		if(products.isEmpty()) throw new ProductException("Products are not available ");	
		return products.get();
	}
	
	@Override
	public List<Product> searchProduct(String name) throws ProductException {
		List<Product> products=pr.searchByName(name);
		
		if(products.size()==0) throw new ProductException("no product  found by this Name "+name);
		return products;
	}

	@Override
	public Product viewProduct(Integer id) throws ProductException {
		Optional<Product> product=pr.findById(id);
		
		if(product.isEmpty()) throw new ProductException("product not exist with this product id "+id);

		return product.get();
	}

	@Override
	public List<Product> filterByPrice(Integer firstPrice, Integer secondPrice) throws ProductException {
		List<Product> products= pr.filterByPrice(firstPrice-1, secondPrice+1);
		if(products.size()==0) throw new ProductException("No any product exist between this range");
		return products;
	}

	@Override
	public List<Product> sortByAscending() throws ProductException {
		List<Product> products=pr.sortByAscending();
		
		if(products.size()==0) throw new ProductException("products are not available") ;
		return products;
	}

	@Override
	public List<Product> sortByDescending() throws ProductException {
		List<Product> products=pr.sortByDescenging();
		
		if(products.size()==0) throw new ProductException("products are not available") ;
		return products;
	}


	@Override
	public List<Product> filterByPriceOnCategory(Integer firstPrice, Integer secondPrice,Integer id) throws ProductException {
		Category products= category.filterByPrice(firstPrice-1, secondPrice+1,id);
		if(products.getProducts().size()==0) throw new ProductException("No any product exist between this range");
		return products.getProducts();
	}


	@Override
	public List<Product> sortByAscendingOnRating() throws ProductException {
		List<Product> products=pr.sortByAscendingOnRating();
		if(products.size()==0) throw new ProductException("No such product exist");
		return products;
	}


	@Override
	public List<Product> sortByDescendingOnRating() throws ProductException {
		List<Product> products=pr.sortByDescengingOnRating();
		if(products.size()==0) throw new ProductException("No such product exist");
		return products;
	}


	@Override
	public List<Product> sortByAscendingOnCategory(Integer id) throws ProductException, CategoryException {
		Optional<Category> categorys =category.findById(id);
		
		if(categorys.isEmpty()) throw new CategoryException("category not exist with this category Id "+id);
		
		Category cat=categorys.get();
		List<Product> products=cat.getProducts();
		
		Collections.sort(products,new Comparator<Product>(){

			public int compare(Product p1, Product p2) {
				if(p1.getSalePrice()>p2.getSalePrice()) return 1;
				else if(p1.getSalePrice()<p2.getSalePrice()) return -1;
				else  return 0;
			}
		});
		return products;
	}


	@Override
	public List<Product> sortByDescendingOnCategory(Integer id) throws ProductException, CategoryException {
		Optional<Category> categorys =category.findById(id);
		
		if(categorys.isEmpty()) throw new CategoryException("category not exist with this category Id "+id);
		
		Category cat=categorys.get();
		List<Product> products=cat.getProducts();
		
		Collections.sort(products,new Comparator<Product>(){

			public int compare(Product p1, Product p2) {
				if(p1.getSalePrice()>p2.getSalePrice()) return -1;
				else if(p1.getSalePrice()<p2.getSalePrice()) return 1;
				else  return 0;
			}
		});
		return products;
	}


	@Override
	public List<Product> sortByAscendingOnRatingInCategory(Integer id) throws ProductException, CategoryException {
		Optional<Category> categorys =category.findById(id);
		
		if(categorys.isEmpty()) throw new CategoryException("category not exist with this category Id "+id);
		
		Category cat=categorys.get();
		List<Product> products=cat.getProducts();
		
		Collections.sort(products,new Comparator<Product>(){

			public int compare(Product p1, Product p2) {
				if(p1.getRating()>p2.getRating()) return 1;
				else if(p1.getSalePrice()<p2.getSalePrice()) return -1;
				else  return 0;
			}
		});
		return products;
	}


	@Override
	public List<Product> sortByDescendingOnRatingInCategory(Integer id) throws ProductException, CategoryException {
		Optional<Category> categorys =category.findById(id);
		
		if(categorys.isEmpty()) throw new CategoryException("category not exist with this category Id "+id);
		
		Category cat=categorys.get();
		List<Product> products=cat.getProducts();
		
		Collections.sort(products,new Comparator<Product>(){

			public int compare(Product p1, Product p2) {
				if(p1.getRating()>p2.getRating()) return -1;
				else if(p1.getSalePrice()<p2.getSalePrice()) return 1;
				else  return 0;
			}
		});
		return products;
	}


	@Override
	public List<Product> filterByRating(Double rating) throws ProductException {
		List<Product> products =pr.filterByRating(rating);
		if(products.size()==0) throw new ProductException("products are not available") ;
		return products;
	}


	@Override
	public List<Product> filterByRatingOnCategory(Double rating,Integer id) throws ProductException, CategoryException {
		Optional<Category> categorys =category.findById(id);
		
		if(categorys.isEmpty()) throw new CategoryException("category not exist with this category Id "+id);
		
		Category cat=categorys.get();
		List<Product> products=cat.getProducts();
		

			
			
			
//		return products;
	}

	

}
