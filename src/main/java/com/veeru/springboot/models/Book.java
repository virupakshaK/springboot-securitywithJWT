/**
 * 
 */
package com.veeru.springboot.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

/**
 * @author virupaksha.kuruva
 *
 */
/*
 * @Data
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 */
@Entity
@Builder
public class Book {

	@Id
	@SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	private int id;
	private String name;
	private String author;
	private float price;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date publishedYear;
	
	
	
	public Book() {
		super();
		
	}
	public Book(int id, String name, String author, float price, Date publishedYear) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.publishedYear = publishedYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(Date publishedYear) {
		this.publishedYear = publishedYear;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", publishedYear="
				+ publishedYear + "]";
	}
	
	
}
