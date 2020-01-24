package com.gb.myfirstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gb.myfirstapi.bean.Book;
import com.gb.myfirstapi.exception.BookNotFoundException;
import com.gb.myfirstapi.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping(value = "/books")
	public List<Book> getBooks() {
		return repository.findAll();
	}

	@PostMapping(value = "/book")
	public Book saveBook(@RequestBody Book book) {
		return repository.save(book);
	}

	@GetMapping(value = "/book/{bookId}")
	public Book findById(@PathVariable("bookId") int bookId) {
		return repository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book Not found for the id "+bookId));
	}

	@PutMapping(value = "/book")
	public Book saveOrUpdate(@RequestBody Book book) {
		return repository.save(book);
	}

	@DeleteMapping(value = "/book/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		Book book = repository.findById(bookId).get();
		repository.delete(book);
	}
}
