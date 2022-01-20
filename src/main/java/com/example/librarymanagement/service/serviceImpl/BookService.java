package com.example.librarymanagement.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.dao.AuthorRepository;
import com.example.librarymanagement.dao.BookRepository;
import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.IBookService;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Book> getAllBooks(int authorId) {

		Author author = authorRepository.findById(authorId).get();
		List<Book> books = author.getBooks();
		return books;
	}

	@Override
	public Book getBook(int authorId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		return book;
	}

	@Override
	public void deleteBook(int authorId, int bookId) {

		bookRepo.deleteById(bookId);
	}

	@Override
	public Book updateBook(int authorId, Book book) {
		Author author = authorRepository.findById(authorId).get();
		book.setAuthor(author);
		Book updateBook = bookRepo.save(book);
		return updateBook;
	}

	@Override
	public Book createBook(int authorId, Book book) {

		Author author = authorRepository.findById(authorId).get();
		book.setAuthor(author);
		Book newBook = bookRepo.save(book);
		return newBook;
	}

}
