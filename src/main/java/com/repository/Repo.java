package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.entity.Book;

public interface Repo extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);
}
