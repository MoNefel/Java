package com.pnc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.pnc.models.*;
import com.pnc.reposotories.CategoryRepo;

@Service
public class CategoryService {
	
	private final CategoryRepo cateRepo;

	public CategoryService(CategoryRepo cateRepo) {
		this.cateRepo = cateRepo;
	}
	
	public List<Category> allCategories(){
		return cateRepo.findAll();
	}
	
	public List<Category> getAssignedCategories(Product product){
		return cateRepo.findAllByProducts(product);
	}
	
	public List<Category> getUnassignedCategories(Product product){
		return cateRepo.findByProductsNotContains(product);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = cateRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public Category addCategory(Category category) {
		return cateRepo.save(category);
	}
	
	public Category updateCategory(Category category) {
		return cateRepo.save(category);
	}
	
	public void deleteCategory(Category category) {
		cateRepo.delete(category);
	}
	
	

}
