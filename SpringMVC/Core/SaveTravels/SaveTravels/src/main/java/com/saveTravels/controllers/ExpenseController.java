package com.saveTravels.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saveTravels.models.Expense;
import com.saveTravels.services.ExpenseService;

import jakarta.validation.Valid;


@Controller
public class ExpenseController {
	
	private final ExpenseService expenseSer;
		
	public ExpenseController(ExpenseService expenseSer) {
		this.expenseSer = expenseSer;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseSer.findAllExpenses();
		model.addAttribute("expenses", expenses);
		return "Index.jsp";
	}
	
	@PostMapping("/expenses")
	public String index(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseSer.findAllExpenses();
			model.addAttribute("expenses", expenses);
			return "Index.jsp";
		}else {
			expenseSer.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("expense", expenseSer.findOneExpense(id));
		return "EditForm.jsp";
	}
	
	@PostMapping("/expenses/edit/{id}")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expenseSer.findOneExpense(id));
			return "redirect:/edit/{id}";
		}else {
			expenseSer.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/expenses/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseSer.findOneExpense(id));
		return "Show.jsp";
	}
	
	@RequestMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		Expense expense = expenseSer.findOneExpense(id);
		expenseSer.deleteExpense(expense);
		return "redirect:/expenses";
	}

}
