package com.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.book.models.*;
import com.book.services.*;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	private final UserService userSer;
	private final BookService bookSer;

	public MainController(UserService userSer, BookService bookSer) {
		this.userSer = userSer;
		this.bookSer = bookSer;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("logUser", new UserLogin());
		return "Index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		userSer.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("logUser", new UserLogin());
			return "Index.jsp";
		}

		session.setAttribute("userId", newUser.getId());

		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newUser") UserLogin newUser, BindingResult result, Model model,
			HttpSession session) {

		User user = userSer.login(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "Index.jsp";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {

		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("books", bookSer.getAllBooks());
		model.addAttribute("user", userSer.findById((Long) session.getAttribute("userId")));
		return "Home.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}

	@GetMapping("/book/new")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		User user = userSer.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "FormAddBook.jsp";
	}

	@PostMapping("/book")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "FormAddBook.jsp";
		}
		bookSer.addBook(book);
		return "redirect:/home";
	}

	@GetMapping("/books/{id}")
	public String showPage(Model model, @PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book book = bookSer.getOneBook(id);
		model.addAttribute("book", book);
		model.addAttribute("user", userSer.findById((Long) session.getAttribute("userId")));

		return "Book.jsp";
	}

	@GetMapping("/book/{id}/edit")
	public String editBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book book = bookSer.getOneBook(id);
		model.addAttribute("book", book);
		User user = userSer.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "FormEditBook.jsp";
	}

	@PutMapping("/book/{id}/update")
	public String updateBook(@Valid Model model, @ModelAttribute("book") Book book, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "FormEditBook.jsp";
		}
		bookSer.editBook(book);

		return "redirect:/home";
	}

	@GetMapping("/book/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		bookSer.deleteBook(id);
		return "redirect:/home";
	}

	@GetMapping("/book/{id}/borrow")
	public String borrowBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book book = bookSer.getOneBook(id);
		book.setBorrower(userSer.findById((Long) session.getAttribute("userId")));
		bookSer.editBook(book);
		return "redirect:/home";
	}

	@GetMapping("/book/{id}/return")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book book = bookSer.getOneBook(id);
		book.setBorrower(null);
		bookSer.editBook(book);
		return "redirect:/home";

	}

}
