/**
 * 
 */
package com.veeru.springboot.security.services;

import com.veeru.springboot.security.models.Book;

/**
 * @author virupaksha.kuruva
 *
 */
public interface BookStoreService {

	public Book addBook(Book book);

	public Book getBook(int bookId);

	public Book updateBook(Book book);

	public String updateBookPrice(float price, int bookId);

	public int deleteBook(Book book);
}
