package com.dojo.controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.models.Answer;
import com.dojo.models.Question;
import com.dojo.models.Tag;
import com.dojo.services.*;

import jakarta.validation.Valid;

@Controller
public class MainController {

	private final QuestionService questionSer;
	private final AnswerService answerSer;
	private final TagService tagSer;

	public MainController(QuestionService questionSer, AnswerService answerSer, TagService tagSer) {
		this.questionSer = questionSer;
		this.answerSer = answerSer;
		this.tagSer = tagSer;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionSer.allQuestions());
		return "Index.jsp";
	}

	@GetMapping("/question/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "QuestionForm.jsp";
	}

	@PostMapping("/question/new")
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result,
			@RequestParam("listOfTags") String listOfTags, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "QuestionForm.jsp";
		}

		List<Tag> questionTags = checkTags(listOfTags);

		if (questionTags == null || questionTags.size() > 3) {
			redirectAttributes.addFlashAttribute("error", "The number of tags must be between 1 and 3");
			return "redirect:/question/new";
		}

		question.setTags(questionTags);
		questionSer.addQuestion(question);

		return "redirect:/";
	}

	private List<Tag> checkTags(String tags) {
		if (tags.length() > 0) {
			ArrayList<Tag> questionTags = new ArrayList<Tag>();
			String[] tagList = tags.split(",");
			for (String tagString : tagList) {
				Tag tag = tagSer.findBySubject(tagString.toLowerCase().strip());
				if (tag == null) {
					tag = new Tag(tagString.toLowerCase().strip());
					tagSer.addTag(tag);
				}
				questionTags.add(tag);
			}
			return questionTags;
		}
		return null;
	}

	@GetMapping("/question/{id}")
	public String viewQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", questionSer.findById(id));
		return "ShowQuestion.jsp";
	}

	@PostMapping("/question/{questionId}/answer/new")
	public String newAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result,
			@PathVariable("questionId") Long id, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("question", questionSer.findById(id));
			return "viewQuestion.jsp";
		}

		answer.setQuestion(questionSer.findById(id));
		answerSer.addAnswer(answer);

		return "redirect:/question/" + id;
	}

}
