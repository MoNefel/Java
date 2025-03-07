package com.pm.services;

import java.util.*;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pm.models.LoginUser;
import com.pm.models.User;
import com.pm.repositories.UserRepo;

@Service
public class UserService {

	private final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User register(User newUser, BindingResult result) {

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

		// Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);

	}

	public User login(LoginUser newLogin, BindingResult result) {

		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());

		// Find user in the DB by email
		// Reject if NOT present
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}

		// User exists, retrieve user from DB
		User user = potentialUser.get();

		// Reject if BCrypt password match fails
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}

		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}

		// Otherwise, return the user object
		return user;

	}

	public List<User> allUsers() {
		return userRepo.findAll();
	}

	public User updateUser(User user) {
		return userRepo.save(user);
	}

	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

}
