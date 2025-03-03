package com.burger.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.burger.models.Burger;
import com.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
	
private final BurgerRepository burgerRepo;
	
	public BurgerService(BurgerRepository burgerRepo) {
		this.burgerRepo = burgerRepo;
	}
	
	
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	
	public Burger addBurger(Burger burger) {
		return burgerRepo.save(burger);
	}

}
