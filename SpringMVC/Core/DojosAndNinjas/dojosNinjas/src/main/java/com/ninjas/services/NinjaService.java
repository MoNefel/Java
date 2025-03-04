package com.ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninjas.models.Ninja;
import com.ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	
	private final NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	
	public List<Ninja> getAllNinja(){
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja getOneNinja(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}
		return null;
	}
	
	
	
	
}
