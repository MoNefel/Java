package com.springMvc.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.springMvc.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findAll();
	
	Optional<User> findByEmail(String email);

}
