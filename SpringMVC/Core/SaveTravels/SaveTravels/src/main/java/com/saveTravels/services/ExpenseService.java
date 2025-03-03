package com.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saveTravels.models.Expense;
import com.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepo;

	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	

	public List<Expense> findAllExpenses() {
		return expenseRepo.findAll();
	}

	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	public Expense findOneExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	public void deleteExpense(Expense expense) {
		expenseRepo.delete(expense);
	}

}
