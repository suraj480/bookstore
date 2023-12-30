package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.services.BookService;
import com.bookstore.services.MyBookListService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping
	public String Home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getAllBook();
		return new ModelAndView("bookList", "books", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.saveBook(book);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List <MyBookList> list =myBookListService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}

	@RequestMapping("mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookListService.saveMyBook(mb);
		return "redirect:/my_books";
	}
}
