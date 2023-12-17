package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Book;
import com.repository.Repo;

@Component  
public class BookService {

	@Autowired
	private Repo repo;
	
	//Repo repo1 = new Repo();
    	
	//get all book
	public List<Book> getAllBook(){
		List<Book> list =(List<Book>)this.repo.findAll(); 
		return list;
	}
	
	//get a single book 
	public Book getSingleBook(int id) {
		Book book = null;
		book = this.repo.findById(id);
		return book;
	}
	
	//adding the new book 
	public Book addBook(Book book) {
		Book result = this.repo.save(book);
		return result;
	}

	//delete book id
	public void deleteBook(int bookId) {
		this.repo.deleteById(bookId);
	}

	public void updateBook(Book b, int bookId) {

		b.setId(bookId); 
		this.repo.save(b);  
		}
	
	
	
	
}
