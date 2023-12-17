package com.api.book.controllers;


import java.util.List;

import javax.management.ConstructorParameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Book;
import com.service.BookService;

//@Controller 

@RestController    //we don't need to write the responseBody 
public class BookController {
    
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	//@GetMapping("/books")        //this is the combination of the both value and method
	public Book getBooks() {
		Book book = new Book();
		book.setId(1);
		book.setName("java Book");
		book.setAuthor("createing by akash");
		return book;  //return the values in the from of json boot automaticlly provide this 
	}
	
	BookService ser = new BookService();
	
	//@Autowired    //create the object and pest here 
	//public BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return ser.getAllBook();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return ser.getSingleBook(id);
	}
	
	//post method that use to create the object
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = ser.addBook(book);
		return b;  //responce to the clint
	}
	
	
	//delete 
//	@DeleteMapping("/books/{bookId}")   //url templet varible spcify
//	public void deleteBook(@PathVariable("bookId") int bookId) {
//		// now we are sending the request to the sevice /database
//		ser.deleteBook(bookId);
//	}
	
	//put the method this method update the existing data
	
	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Book b, @PathVariable("bookId") int bookId) {
		ser.updateBook(b,bookId);   //requestbody convert the json data into object and give to the book object
		//return b;
	}
	
	
}
