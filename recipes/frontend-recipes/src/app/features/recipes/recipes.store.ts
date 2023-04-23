import { Injectable } from '@angular/core';
import { Recipe } from 'src/app/core/model/recipe.model';

@Injectable({
  providedIn: 'root'
})
export class RecipesStore {

  recipes: Recipe[] = [];
  activeRecipe: Recipe = {} as Recipe;

  readRecipe(recipes: Recipe[]) {
    this.recipes = recipes;
  }

  delRecipe(recipe: Recipe){
    this.recipes = this.recipes.filter( r => r.id !== recipe.id);
  }

  updateRecipe(recipe: Recipe){
    this.recipes = this.recipes.map( r => r.id === recipe.id ? recipe : r);
  }

  createRecipe(recipe: Recipe){
    this.recipes = [...this.recipes, recipe];
  }

  setRecipe(recipe: Recipe) {
    this.activeRecipe = recipe;
  }

  resetRecipe() {
    this.activeRecipe = {} as Recipe;
  }

}
