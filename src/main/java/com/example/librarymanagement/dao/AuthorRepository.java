package com.example.librarymanagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagement.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
