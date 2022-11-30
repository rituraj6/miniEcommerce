package com.masai.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	@Query("from Category where salePrice>?1 and salePrice<?2 and id=?3")
	public Category filterByPrice(Integer start,Integer end,Integer id);
	

}
