package com.pnc.controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.pnc.models.*;
import com.pnc.services.*;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	private final ProductService proSer;
	private final CategoryService cateSer;
	
	public MainController(ProductService proSer, CategoryService cateSer) {
		this.proSer = proSer;
		this.cateSer = cateSer;
	}
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = proSer.allProducts();
		List<Category> categories = cateSer.allCategories();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "Index.jsp";	
	}
	
	//Categories
	
	@GetMapping("/category/new")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "Category.jsp";
	}
	
	
	@PostMapping("/category")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		cateSer.addCategory(category);
		return "redirect:/";
	}
	
	
	@GetMapping("/category/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model model) {
		Category category = cateSer.findById(id);
		model.addAttribute("category", category);
		model.addAttribute("assignedProducts", proSer.getAssignedProducts(category));
		model.addAttribute("unassignedProducts", proSer.getUnassignedProducts(category));
		return "ShowCategory.jsp";
	}
	
	@PostMapping("/category/{id}")
	public String updateCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
		Category category = cateSer.findById(id);
		Product product = proSer.findById(productId);
		category.getProducts().add(product);
		cateSer.updateCategory(category);
		return "redirect:/category/"+id;
	}
	
	
	
	
	//Products
	@GetMapping("/product/new")
	public String addProduct(@ModelAttribute("product")Product product) {
		return "Product.jsp";
	}
	
	
	@PostMapping("/product")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		proSer.addProduct(product);
		return "redirect:/";
	}
	
	
	@GetMapping("/product/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model model) {
		Product product = proSer.findById(id);
		model.addAttribute("product", product);
		model.addAttribute("assignedCategories", cateSer.getAssignedCategories(product));
		model.addAttribute("unassignedCategories", cateSer.getUnassignedCategories(product));
		return "ShowProduct.jsp";
	}
	
	
	
	@PostMapping("/product/{id}")
	public String updateProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long categoryId, Model model) {
		Product product = proSer.findById(id);
		Category category = cateSer.findById(categoryId);
		product.getCategories().add(category);
		proSer.updateProduct(product);
		return "redirect:/product/"+id;
	}
	
	

	
	
	

}
