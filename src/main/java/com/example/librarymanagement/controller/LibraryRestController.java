package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.IBookService;

@RestController
@RequestMapping("/api")
public class LibraryRestController {

	@Autowired
	IBookService bookService;

	@GetMapping("/author/{authorId}/book")
	public ResponseEntity<List<Book>> getAllBooks(@PathVariable int authorId) {

		List<Book> books = bookService.getAllBooks(authorId);

		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@GetMapping("/author/{authorId}/book/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable int authorId, @PathVariable int bookId) {

		Book book = bookService.getBook(authorId, bookId);

		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@PostMapping("/author/{authorId}/book")
	public ResponseEntity<Book> postBook(@PathVariable int authorId, @RequestBody Book book) {

		Book newBook = bookService.createBook(authorId, book);

		return new ResponseEntity<>(newBook, HttpStatus.CREATED);
	}

	@DeleteMapping("/author/{authorId}/book/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable int authorId, @PathVariable int bookId) {

		bookService.deleteBook(authorId, bookId);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/author/{authorId}/book/")
	public ResponseEntity<Book> updateBook(@PathVariable int authorId, @RequestBody Book book) {
		Book updatedBook = bookService.updateBook(authorId, book);

		return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
	}

}
