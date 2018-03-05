package com.vasanth.spring5webapp.dao;

import com.vasanth.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
