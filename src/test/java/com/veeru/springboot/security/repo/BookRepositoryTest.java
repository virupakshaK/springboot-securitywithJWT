/**
 * 
 */
package com.veeru.springboot.security.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.veeru.springboot.security.models.Book;

/**
 * @author virupaksha.kuruva
 *
 */
@ContextConfiguration
//@DataJpaTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@BeforeEach
	public void setUp() throws Exception {
		Book book = Book.builder().id(1)
				  .name("Java")
				  .author("Jai")
				  .price(233.4f).build();
		testEntityManager.persist(book);
		
	}

	
	@Test
	public void testFindById() {
	
		int bookId = 1;
		
		Book foundBook = bookRepository.findById(bookId).get();
		assertEquals("Java", foundBook.getAuthor());
	}

}
