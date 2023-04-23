package com.manuelservi.springbootblognovembre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manuelservi.springbootblognovembre.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
