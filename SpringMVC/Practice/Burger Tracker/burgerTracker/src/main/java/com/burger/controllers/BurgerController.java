package com.burger.controllers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.burger.models.Burger;
import com.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	
	private final BurgerService burgerSer;
			
	public BurgerController(BurgerService burgerSer) {
		this.burgerSer = burgerSer;
	}

	@GetMapping("/")
	public String home(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerSer.allBurgers();
		model.addAttribute("burgers", burgers);
		return "Index.jsp";
	}
	
	@PostMapping("/burger")
	public String home(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Burger> burgers = burgerSer.allBurgers();
			model.addAttribute("burgers", burgers);
			return "Index.jsp";
		}
		burgerSer.addBurger(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burger/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("burger", burgerSer.getOneBurger(id));
		return "EditForm.jsp";
	}

	@PutMapping("/burger/{id}")
	public String editBurger(@Valid @ModelAttribute("burger")Burger burger,
			BindingResult result, @PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "EditForm.jsp";
		}
		burgerSer.editBurger(burger);
		return "redirect:/";
		}

}
