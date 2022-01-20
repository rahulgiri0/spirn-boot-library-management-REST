package com.example.librarymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarymanagement.model.Book;

@Service
public interface IBookService {

	List<Book> getAllBooks(int authorId);

	Book getBook(int authorId, int bookId);

	void deleteBook(int authorId, int bookId);

	Book updateBook(int authorId, Book book);

	Book createBook(int autorId, Book book);

}
