package com.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.models.Answer;
import com.dojo.repositories.AnswerRepo;

@Service
public class AnswerService {

	private final AnswerRepo answ;

	public AnswerService(AnswerRepo answ) {
		this.answ = answ;
	}

	public Answer addAnswer(Answer answer) {
		return answ.save(answer);
	}

	public List<Answer> questionAnswers(Long questionId) {
		return answ.findByQuestionIdIs(questionId);
	}

}
