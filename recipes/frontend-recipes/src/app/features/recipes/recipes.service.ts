import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Recipe } from 'src/app/core/model/recipe.model';
import { environment } from 'src/environments/environment';
import { RecipesStore } from './recipes.store';

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  constructor(
    private httpClient : HttpClient,
    private recipesStore : RecipesStore
  ) { }

  readRecipe() {
    const url = environment.baseUrl + "/recipes";
    this.httpClient.get<Recipe[]>(url).subscribe(data => this.recipesStore.readRecipe(data))
  }

  delRecipe(recipe: Recipe){
    const url = environment.baseUrl + "/recipes/"  + recipe.id;
    this.httpClient.delete<any>(url).subscribe ( () => this.recipesStore.delRecipe(recipe));
  }

  updateRecipe(recipe: Recipe) {
    const url = environment.baseUrl +'/recipes/'+ recipe.id;
    this.httpClient.put<Recipe>(url, recipe).subscribe( data => this.recipesStore.updateRecipe(data));
  }

  createRecipe(recipe: Recipe) {
    const url = environment.baseUrl + '/recipes';
    this.httpClient.post<Recipe>(url, recipe).subscribe(data => this.recipesStore.createRecipe(data));
  }

  setRecipe(recipe: Recipe) {
    this.recipesStore.setRecipe(recipe);
  }

  resetRecipe() {
    this.recipesStore.resetRecipe();
  }


}
