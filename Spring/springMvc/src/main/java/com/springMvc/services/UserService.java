package com.springMvc.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.springMvc.models.LoginUser;
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
	
	
	public User register(User newUser, BindingResult result) {
		//check if the user email exist or not.
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}

		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}

		if (result.hasErrors()) {
			return null;
		}

		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	
	
	public User login(LoginUser logUser, BindingResult result) {
		
		Optional<User> potentialUser = userRepo.findByEmail(logUser.getEmail());

		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}

		User userFromDb = potentialUser.get();

		if (!BCrypt.checkpw(logUser.getPassword(), userFromDb.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}

		if (result.hasErrors()) {
			return null;
		}

		return userFromDb;
	}
	
	
	

}
