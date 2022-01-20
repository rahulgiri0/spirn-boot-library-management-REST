package com.example.librarymanagement.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.dao.AuthorRepository;
import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.service.IAuthorService;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorRepository authorRepo;

	@Override
	public Author createAuthor(Author author) {
		Author addAuthor = authorRepo.save(author);
		return addAuthor;
	}

	@Override
	public List<Author> getAllAuthor() {
		List<Author> authors = (List<Author>) authorRepo.findAll();
		return authors;

	}

	@Override
	public Author getAuthor(int authorId) {
		// TODO Auto-generated method stub
		Author author = authorRepo.findById(authorId).get();
		return author;

	}

	@Override
	public void deleteAuthor(int authorId) {
		authorRepo.deleteById(authorId);

	}

	@Override
	public Author updateAuthor(Author author) {
		Author updateAuthor = authorRepo.save(author);
		return updateAuthor;
	}

}
