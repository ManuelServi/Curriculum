package com.bezkoder.spring.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.models.Recipe;
import com.bezkoder.spring.login.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository repository;
	
	public List<Recipe> read() {
		return repository.findAll();
	}
	
	public Recipe create(Recipe recipe) {
		return repository.save(recipe);
	}
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public Recipe update (int id, Recipe newRecipe) {
		Recipe recipe =repository.findById(id).get();
		recipe.setTitle(newRecipe.getTitle());
		recipe.setDescription(newRecipe.getDescription());
		recipe.setIngredients(newRecipe.getIngredients());
		recipe.setTime(newRecipe.getTime());
		recipe.setCategory(newRecipe.getCategory());
		recipe.setLevel(newRecipe.getLevel());
		return repository.save(recipe);
	}
}
