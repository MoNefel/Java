package com.ninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ninjas.models.Dojo;
import com.ninjas.models.Ninja;
import com.ninjas.services.DojoService;
import com.ninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {

	private final DojoService dojoSer;
	private final NinjaService ninjaSer;

	public MainController(DojoService dojoSer, NinjaService ninjaSer) {
		this.dojoSer = dojoSer;
		this.ninjaSer = ninjaSer;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("dojos", dojoSer.getAllDojos());
		return "Index.jsp";
	}

	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "AddDojoForm.jsp";
	}

	@PostMapping("/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "AddDojoForm.jsp";
		} else {
			dojoSer.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String oneDojo(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoSer.getOneDojo(id));
		return "ViewDojo.jsp";
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(Model model, @ModelAttribute("ninja")Ninja ninja) {
		model.addAttribute("dojos", dojoSer.getAllDojos());
		return "AddNinjaForm.jsp";
		
	}
	
	
	@PostMapping("/ninja")
	public String addNinja(Model model, @Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoSer.getAllDojos());
			return "AddNinjaForm.jsp";
		}else {
			ninjaSer.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
