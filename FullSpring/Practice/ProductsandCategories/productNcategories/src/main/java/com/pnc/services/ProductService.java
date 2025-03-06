package com.pnc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.pnc.models.*;
import com.pnc.reposotories.ProductRepo;

@Service
public class ProductService {
	
	private final ProductRepo proRepo;

	public ProductService(ProductRepo proRepo) {
		this.proRepo = proRepo;
	}
	
	public List<Product> allProducts(){
		return proRepo.findAll();
	}
	
	public List<Product> getAssignedProducts(Category category){
		return proRepo.findAllByCategories(category);
	}
	
	public List<Product> getUnassignedProducts(Category category){
		return proRepo.findByCategoriesNotContains(category);
	}
	
	public Product findById(Long id) {
		Optional<Product> optionalProduct = proRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	public Product addProduct(Product product) {
		return proRepo.save(product);
	}
	
	public Product updateProduct(Product product) {
		return proRepo.save(product);
	}
	
	public void deleteProduct(Product product) {
		proRepo.delete(product);
	}

}
