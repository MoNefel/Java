package com.springMvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springMvc.models.User;
import com.springMvc.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
		}
	
	public User getOneUser(Long id) {
	Optional<User> user = userRepo.findById(id);
	if(user.isPresent()) {
		return user.get();
	}else {
		return null;
	}
	}
	
	public User editUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	
	
	

}
