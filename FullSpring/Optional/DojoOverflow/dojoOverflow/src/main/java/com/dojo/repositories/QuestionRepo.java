package com.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{
	
	List<Question> findAll();
	
	Question findByIdIs(Long id);

}
