package com.veeru.springboot.security.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veeru.springboot.security.exceptions.EmptyInputParam;
import com.veeru.springboot.security.models.Book;
import com.veeru.springboot.security.services.BookStoreService;
/**
 * @author virupaksha.kuruva
 *
 */
//@CrossOrigin("localhost")
@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

	@Autowired
	BookStoreService bookStoreService;
	
	@GetMapping("/greetings")
	public String greetingMessage(@PathParam(value = "Viru") String name) {
		
		return "Hi.. "+name+", \n Welcome to spring boot security world...!";
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> addNewBook(@RequestBody Book book) {

		Book book1 = bookStoreService.addBook(book);
		if(book1.getId()>0)
			return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Book is not added", HttpStatus.METHOD_FAILURE);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {

		Book book1 = bookStoreService.updateBook(book);

		return new ResponseEntity<Book>(book1, HttpStatus.OK);
	}
	
	@PatchMapping("/updateBookPrice")
	public ResponseEntity<String> updateBookPrice(@RequestBody Book book) {

		String priceUpdate = bookStoreService.updateBookPrice(book.getPrice(), book.getId());

		return new ResponseEntity<String>(priceUpdate, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getBook(int bookId) {

		Book book1 = bookStoreService.getBook(bookId);
		return new ResponseEntity<Book>(book1, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBook(int bookId) {

		if (bookId > 0) {
			Book book1 = Book.builder().id(bookId).build();
			int deleteStatus = bookStoreService.deleteBook(book1);
			if (deleteStatus >= 1) {
				return new ResponseEntity<String>("Book deleted succeessfully.", HttpStatus.OK);
			}
		} else {
			throw new EmptyInputParam("Book id not found", 400);
		}

		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

}
