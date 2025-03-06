package com.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long>{
	
	List<Answer> findByQuestionIdIs(Long id);

}
