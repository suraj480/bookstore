package com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;

	public void saveBook(Book book) {
		bookRepo.save(book);
	}

	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}

	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
}
