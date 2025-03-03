package com.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.book.models.Book;
import com.book.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BooksApiController {

	private final BookService bookSer;

	public BooksApiController(BookService bookSer) {
		this.bookSer = bookSer;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allBooks", bookSer.allBooks());
		return "index.jsp";
	}

	@GetMapping("/book/new")
	public String bookForm(@ModelAttribute("book") Book book) {
		return "FormCreate.jsp";
	}

	@PostMapping("/book")
	public String createUser(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		// if the model has triggere error validation warnings.
		if (result.hasErrors()) {
			return "FormCreate.jsp";
		}
		// if no errors, store into dataBase.
		bookSer.createBook(book);
		return "redirect:/";
	}

	@GetMapping("/book/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookSer.getOneBook(id));
		return "EditForm.jsp";
	}

	@PutMapping("/book/{id}")
	public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result,

			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "EditForm.jsp";
		}
		bookSer.editBook(book);
		return "redirect:/";
	}

	@GetMapping("book/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookSer.deleteBook(id);
		return "redirect:/";
	}

}
