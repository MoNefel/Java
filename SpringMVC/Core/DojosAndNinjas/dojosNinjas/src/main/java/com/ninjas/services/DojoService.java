package com.ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninjas.models.Dojo;
import com.ninjas.repositories.DojoRepository;

@Service
public class DojoService {

	
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	

	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
		}
	
	public Dojo getOneDojo(Long id) {
	Optional<Dojo> dojo = dojoRepo.findById(id);
	if(dojo.isPresent()) {
		return dojo.get();
	}else {
		return null;
	}
	}
	
	
	public Dojo editDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	
	
}
