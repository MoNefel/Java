package com.pnc.reposotories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pnc.models.*;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	Product findByIdIs(Long id);
	
	List<Product> findAllByCategories(Category category);
	
	List<Product> findByCategoriesNotContains(Category category);

}
