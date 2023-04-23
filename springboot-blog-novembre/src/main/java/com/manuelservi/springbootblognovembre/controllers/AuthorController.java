package com.manuelservi.springbootblognovembre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.manuelservi.springbootblognovembre.models.Author;
import com.manuelservi.springbootblognovembre.models.Post;
import com.manuelservi.springbootblognovembre.services.AuthorService;


@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping("/authors")
	@CrossOrigin("*")
	public List<Author> listAll() {
		return service.listAll();
		}
	
	@PostMapping("/authors")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Author create(@RequestBody Author post) {
		return service.store(post);	
	}
	
	@DeleteMapping("/authors/{id}")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/authors/{id}")
	@CrossOrigin("*")
	public Author update(@RequestBody Author author, @PathVariable int id ) {
		return service.update(id, author);
	}
	
	
}

