package com.apiapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiapp.entities.Book;
import com.apiapp.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookServices;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookServices.getAllBooks();
		/*Book book=new Book();
		book.setId(0);
		book.setTitle("Java");
		book.setAuthor("Rehan");
		return book;*/
		
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookServices.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookServices.addBook(book);
		return b;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookServices.deleteBook(bookId);
	}
	
	@PutMapping("/books/{bookId}")
	public List<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		return this.bookServices.updateBook(book, bookId);
	}
}
