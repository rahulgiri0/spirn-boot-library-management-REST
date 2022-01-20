package com.example.librarymanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagement.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
