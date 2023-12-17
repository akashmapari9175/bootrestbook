package com.refrenceofall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Book;
import com.repository.Repo;

public class BookServiceNew {

	
	
//	private static List<Book> list = new ArrayList<Book>();
//	
//	static {
//		list.add(new Book(12,"python book ","xyz"));
//		list.add(new Book(1223,"java book ","abc"));
//		list.add(new Book(1256,"c book ","pqr"));
//	}
	@Autowired
	private Repo repo;
	
	//Repo repo1 = new Repo();
    	
	//get all book
	public List<Book> getAllBook(){
		List<Book> list =(List<Book>)this.repo.findAll();  //parent class can be type cast into child class
		return list;
	}
	
	//get a single book 
	public Book getSingleBook(int id) {
		Book book = null;
		//book = list.stream().filter(e ->e.getId()==id).findFirst().get();
		book = this.repo.findById(id);
		return book;
	}
	
	//adding the new book 
	public Book addBook(Book book) {
		//list.add(book);
		Book result = this.repo.save(book);
		return result;
	}

	//delete book id
	public void deleteBook(int bookId) {
//		list.forEach(e->{
//			if(e.getId()==bookId) {
//				list.remove(e);
//			}
//		});
		this.repo.deleteById(bookId);
	}

	public void updateBook(Book b, int bookId) {
//		list.forEach(e->{
//			if(e.getId()==bookId) {
//				e.setName(b.getName());
//				e.setAuthor(b.getAuthor());
//			}
//		});
		//another way to write
//		list = list.stream().map(e->{
//			if(e.getId()==bookId) {
//				e.setName(b.getName());
//				e.setAuthor(b.getAuthor());
//			}
//			return e;
//		}).collect(Collectors.toList());
		//return b;
		b.setId(bookId);  //if both id will different than set the bookId than automatically save 
		this.repo.save(b);  //this will save the book into database 
	}
	
	
	
	
}
