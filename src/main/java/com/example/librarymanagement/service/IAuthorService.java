package com.example.librarymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarymanagement.model.Author;

@Service
public interface IAuthorService {

	public Author createAuthor(Author author);

	List<Author> getAllAuthor();

	Author getAuthor(int authorId);

	void deleteAuthor(int authorId);

	Author updateAuthor(Author author);

}
