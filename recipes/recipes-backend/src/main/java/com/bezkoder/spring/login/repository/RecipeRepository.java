package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.spring.login.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
