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

import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.service.IAuthorService;

@RestController
@RequestMapping("/api")
public class AuthorRestController {

	@Autowired
	private IAuthorService authorService;

	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAllAuthors() {

		List<Author> author = authorService.getAllAuthor();

		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	@GetMapping("/author/{authorId}")
	public ResponseEntity<Author> getAuthor(@PathVariable int authorId) {

		Author author = authorService.getAuthor(authorId);

		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	@PostMapping("/author")
	public ResponseEntity<Author> postAuthor(@RequestBody Author author) {

		Author newAuthor = authorService.createAuthor(author);

		return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
	}

	@DeleteMapping("/author/{authorId}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable int authorId) {

		authorService.deleteAuthor(authorId);
		return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/author")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
		Author updatedAuthor = authorService.updateAuthor(author);

		return ResponseEntity.status(HttpStatus.OK).body(updatedAuthor);
	}

}
