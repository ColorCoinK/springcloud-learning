package com.learning.controller;

import com.learning.entity.Book;
import com.learning.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id) {
		return this.bookRepository.findOne(id);
	}

}