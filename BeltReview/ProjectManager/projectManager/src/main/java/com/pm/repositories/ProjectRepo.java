package com.pm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.models.*;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long>{
	
	List<Project> findAll();
	
	Project findByIdIs(Long id);
	
	List<Project> findAllByUsers(User user);
	
	List<Project> findByUsersNotContains(User user);

}
