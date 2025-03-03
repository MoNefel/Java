package com.springMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springMvc.models.User;
import com.springMvc.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	private final UserService userSer;

	public UserController(UserService userSer) {
		this.userSer = userSer;
	}

	// Get all users
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allUsers", userSer.getAllUsers());
		return "Index.jsp";

	}

	// Create a new user
	@GetMapping("/user/new")
	public String userForm(@ModelAttribute("user") User user) {
		return "Form.jsp";
	}

	@PostMapping("/user")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		// if the model has triggere error validation warnings.
		if (result.hasErrors()) {
			return "Form.jsp";
		}
		// if no errors, store into dataBase.
		userSer.createUser(user);
		return "redirect:/";
	}

	// Update a user
	@GetMapping("/user/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userSer.getOneUser(id));
		return "EditForm.jsp";
	}

	@PutMapping("/user/{id}")
	public String editUser(@Valid @ModelAttribute("user")User user,
			BindingResult result, @PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "EditForm.jsp";
		}
		userSer.editUser(user);
		return "redirect:/";
		}
	
	@GetMapping("user/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userSer.deleteUser(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
