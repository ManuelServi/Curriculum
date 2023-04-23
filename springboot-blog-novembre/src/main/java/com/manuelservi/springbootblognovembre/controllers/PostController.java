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
import com.manuelservi.springbootblognovembre.models.Post;
import com.manuelservi.springbootblognovembre.services.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/posts")
	@CrossOrigin("*")
	public List<Post> listAll() {
		return service.listAll();
		}
	
	@PostMapping("/posts")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Post create(@RequestBody Post post) {
		return service.store(post);	
	}
	
	@DeleteMapping("/posts/{id}")
	@CrossOrigin("*")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/posts/{id}")
	@CrossOrigin("*")
	public Post update(@RequestBody Post post, @PathVariable int id ) {
		return service.update(id, post);
 }
	
	
	
}
