package com.bookstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.entity.Book;
import com.bookstore.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String Home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	

	@GetMapping("/available_books")
	public String getAllBook() {
		return "bookList";
	}
	@PostMapping("/save")
	public String  addBook(@ModelAttribute Book book) {
		bookService.saveBook(book);
		return "redirect:/available_books";
	}
	
}
