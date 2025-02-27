package com.SpringTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class JSPController {
	
	@GetMapping("/{firstName}/{id}")
	public String index(
			@PathVariable("firstName") String firstName,
			@PathVariable("id") int id,
			Model model) {
		model.addAttribute("firstName", firstName);
		model.addAttribute("id", id);
		model.addAttribute("title", "JSP");
		return "index.jsp";
	}
	
	@GetMapping("/form")
	public String from() {
		return "form.jsp";
	}
	
	@GetMapping("/dash")
	public String dash() {
		return "dash.jsp";
	}
	
	@PostMapping("/register")
	public String reg(
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session,
			RedirectAttributes flash
			) {
		if(firstName.equals("med")) {
			flash.addFlashAttribute("error", "Name can not be chosen");
			return "redirect:/form";
		}
		session.setAttribute("firstName", firstName);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		return "redirect:/dash";
	}
	

}
