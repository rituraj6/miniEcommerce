package com.masai.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query("from Product where productName like '%?1%'")
	public List<Product> searchByName(String name);
	
	@Query("from Product where salePrice>?1 and salePrice<?2")
	public List<Product> filterByPrice(Integer start,Integer end);
	
	@Query("from Product order by salePrice")
	public List<Product> sortByAscending();
	
	@Query("from Product order by salePrice desc")
	public List<Product> sortByDescenging();
	
	@Query("from Product order by rating")
	public List<Product> sortByAscendingOnRating();
	
	@Query("from Product order by rating desc")
	public List<Product> sortByDescengingOnRating();
	
	@Query("from Product where rating=?1 or rating>?1")
	public List<Product> filterByRating(Double rating);
	
	

}
