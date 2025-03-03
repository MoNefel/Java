package com.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.book.models.Book;
import com.book.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// creates a book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

	// retrieves a book
	public Book getOneBook(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}
	}

	//edit book
	public Book editBook(Book book) {
		return bookRepo.save(book);
	}

	//delete book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
