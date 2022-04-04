/**
 * 
 */
package com.veeru.springboot.security.controllers;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.veeru.springboot.security.models.Book;
import com.veeru.springboot.security.services.BookStoreService;
import com.veeru.springboot.security.services.BookStoreServiceImpl;

/**
 * @author virupaksha.kuruva
 *
 */

public class BookStoreControllerTest {

	@MockBean
	BookStoreService bookStoreService;
	
	
	MockMvc mockMvc;
	
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
	Book book = Book.builder().id(1)
							 .name("Java")
							 .author("Veeru")
							 .price(334.2f).build();
		Mockito.when(bookStoreService.getBook(1)).thenReturn(book);			   
	}

	
	@Test
	@DisplayName("testingFetchBookById")
	public void testGetBook() throws Exception {
		Book book = Book.builder().id(1)
				 .name("Java")
				 .author("Veeru")
				 .price(334.2f).build();
		Mockito.when(bookStoreService.getBook(1)).thenReturn(book);	
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:4545/bookstore/get?bookId=1").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
