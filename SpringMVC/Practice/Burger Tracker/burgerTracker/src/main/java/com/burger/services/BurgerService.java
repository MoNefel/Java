package com.burger.services;

import java.util.List;
import java.util.Optional;

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

	
	public Burger getOneBurger(Long id) {
	Optional<Burger> burger = burgerRepo.findById(id);
	if(burger.isPresent()) {
		return burger.get();
	}else {
		return null;
	}
	}
	
	public Burger editBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	public void deleteBurger(Long id) {
		burgerRepo.deleteById(id);
	}
}
