/**
 * 
 */
package com.veeru.springboot.services;

import com.veeru.springboot.models.Book;

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
