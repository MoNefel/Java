package com.book.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.book.models.Book;
import com.book.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public Book getOneBook(Long id) {
		Optional<Book> dojo = bookRepo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}

	public Book editBook(Book book) {
		return bookRepo.save(book);
	}

	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
