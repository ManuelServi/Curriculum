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

import com.manuelservi.springbootblognovembre.models.Comment;
import com.manuelservi.springbootblognovembre.services.CommentService;


@RestController
public class CommentController {
	
	
		@Autowired
		private CommentService service;
		
		@GetMapping("/comments")
		@CrossOrigin("*")
		public List<Comment> listAll() {
			return service.listAll();
			}
		
		@PostMapping("/comments")
		@CrossOrigin("*")
		@ResponseStatus(code = HttpStatus.CREATED)
		public Comment create(@RequestBody Comment comment) {
			return service.store(comment);	
		}
		
		@DeleteMapping("/comments/{id}")
		@CrossOrigin("*")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void delete(@PathVariable int id) {
			service.deleteById(id);
		}
		
		@PutMapping("/comments/{id}")
		@CrossOrigin("*")
		public Comment update(@RequestBody Comment comment, @PathVariable int id ) {
			return service.update(id, comment);
		}
}
