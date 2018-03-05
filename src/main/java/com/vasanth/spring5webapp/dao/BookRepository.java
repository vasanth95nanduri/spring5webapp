package com.vasanth.spring5webapp.dao;

import com.vasanth.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
