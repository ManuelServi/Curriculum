package com.bezkoder.spring.login.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.login.models.Recipe;
import com.bezkoder.spring.login.services.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController  {
	
	@Autowired
	private RecipeService service;
	
	@GetMapping("")
	@CrossOrigin("*")
	public List<Recipe> index(){
		return service.read();
	}
	
	@PostMapping("")
	@CrossOrigin("*")
	@ResponseStatus(code=HttpStatus.CREATED)
	//@PreAuthorize("hasRole('ADMIN') or hasRole('EDITOR')")
	public Recipe create(@RequestBody Recipe recipe) {
		return service.create(recipe);
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins ="*")
	//@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		 service.delete(id);
	}
	
	@PutMapping("/{id}")
	@CrossOrigin("*")
	//@PreAuthorize("hasRole('ADMIN') or hasRole('EDITOR')")
	public Recipe update(@RequestBody Recipe recipe, @PathVariable int id) {
		return service.update(id, recipe);
	}
}
