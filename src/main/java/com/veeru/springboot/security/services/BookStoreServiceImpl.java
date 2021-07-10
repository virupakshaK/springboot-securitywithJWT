package com.veeru.springboot.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veeru.springboot.security.models.Book;
import com.veeru.springboot.security.repo.BookRepository;

/**
 * @author virupaksha.kuruva
 *
 */
@Service
public class BookStoreServiceImpl implements BookStoreService {

	@Autowired
	BookRepository bookRepository;
	
	
	@Override
	@Transactional
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(int bookId) {
		System.out.println("************************Id:"+bookId);
		return bookRepository.findById(bookId).get();
	}

	@Override
	@Transactional
	public Book updateBook(Book book) {
		if (bookRepository.findById(book.getId()) != null) {
			//System.out.println("Id:"+book.getId());
			Book persistenceBook = bookRepository.findById(book.getId()).get();
			if(book.getAuthor() != null) {
				persistenceBook.setAuthor(book.getAuthor());
			}
			if(book.getName() != null) {
				persistenceBook.setName(book.getName());
			}
			if(book.getPrice() > 0) {
				persistenceBook.setPrice(book.getPrice());
			}
			
			return bookRepository.save(persistenceBook);
		}
		return null;
	}

	@Override
	public int deleteBook(Book book) {
		try {
		 bookRepository.delete(book);
		}catch (Exception e) {
		 return 0;
		}
		 return 1;
	}

	@Override
	@Transactional
	public String updateBookPrice(float price, int bookId) {
		bookRepository.updatePrice(price, bookId);
		
		return "Updated price successfully.";
	}

	
}
