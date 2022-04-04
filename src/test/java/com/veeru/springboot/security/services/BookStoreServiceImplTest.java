/**
 * 
 */
package com.veeru.springboot.security.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.veeru.springboot.security.models.Book;
import com.veeru.springboot.security.repo.BookRepository;

/**
 * @author virupaksha.kuruva
 *
 */
//@SpringBootTest(classes = { BookStoreServiceImpl.class })
//@RunWith(SpringRunner.class)
public class BookStoreServiceImplTest {

	
	@MockBean
	private BookRepository bookRepository;
	
	@Autowired
	private BookStoreService bookStoreService;
	
	@BeforeAll
	public void setUp() throws Exception {
		Book book = Book.builder().id(1)
								  .name("Java")
								  .author("Jai")
								  .price(233.4f).build();
		
		Mockito.when(bookRepository.findById(1).get()).thenReturn(book);
		Mockito.when(bookRepository.save(book)).thenReturn(book);
	}

	
	@Test
	public void testFetchBookById() {
		int bookId = 1;
		String author = "Jai";
		Book foundBook = bookStoreService.getBook(bookId);
		assertEquals(author, foundBook.getAuthor());
	}

	@Test
	public void saveBookTest() {
		Book book = Book.builder().id(1)
				  .name("Java")
				  .author("Jai")
				  .price(233.4f).build();
		Book foundBook = bookStoreService.addBook(book);
		assertEquals(book.getId(), foundBook.getId());
	}
}
