package com.book.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.services.BookService;

@Controller
public class BookController {
	
	private final BookService bookSer;

	public BookController(BookService bookSer) {
		this.bookSer = bookSer;
	}

	@GetMapping("/books/show/{id}")
	public String showBook(Model model, @PathVariable("id") Long id) {
		model.addAttribute("oneBook", bookSer.getOneBook(id));
		return "Show.jsp";
	}
	
//	@GetMapping("/books")
//    public String index(Model model) {
//        List<Book> books = bookSer.allBooks();
//        model.addAttribute("books", books);
//        return "/books/index.jsp";
//    }
	

}
