package com.veeru.springboot.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veeru.springboot.security.models.Book;

/**
 * @author virupaksha.kuruva
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Modifying
	@Query(value="update Book b set b.price = :price where b.id = :id", nativeQuery=true)
	public void updatePrice(@Param(value="price")float price, @Param(value="id") Integer id);
}
