package com.pm.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{
	
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	
	User findByIdIs(Long id);

}
