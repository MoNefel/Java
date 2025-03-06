package com.dojo.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.dojo.models.Question;
import com.dojo.repositories.QuestionRepo;

@Service
public class QuestionService {

	private final QuestionRepo quest;

	public QuestionService(QuestionRepo quest) {
		this.quest = quest;
	}
	
	public List<Question> allQuestions(){
		return quest.findAll();
	}

	
	public Question addQuestion(Question question) {
		return quest.save(question);
	}

	
	public Question findById(Long id) {
		Optional<Question> optionalQuestion = quest.findById(id);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}

}
