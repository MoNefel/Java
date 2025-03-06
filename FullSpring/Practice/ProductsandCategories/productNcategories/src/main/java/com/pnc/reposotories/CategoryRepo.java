package com.pnc.reposotories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pnc.models.*;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	
	List<Category> findAll();
	
	Category findByIdIs(Long id);
	
	List<Category> findAllByProducts(Product product);
	
	List<Category> findByProductsNotContains(Product product);
	

}
