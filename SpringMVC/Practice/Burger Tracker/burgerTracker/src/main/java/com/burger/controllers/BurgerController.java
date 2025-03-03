package com.burger.controllers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.burger.models.Burger;
import com.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	
	private final BurgerService burgerService;
			
	public BurgerController(BurgerService burgerService) {
		super();
		this.burgerService = burgerService;
	}

	@GetMapping("/")
	public String home(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "Index.jsp";
	}
	
	@PostMapping("/burger")
	public String home(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "Index.jsp";
		}
		burgerService.addBurger(burger);
		return "redirect:/";
	}

}
