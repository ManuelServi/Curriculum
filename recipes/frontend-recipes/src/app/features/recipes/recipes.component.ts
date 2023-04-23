import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Recipe } from 'src/app/core/model/recipe.model';
import { RecipesService } from './recipes.service';
import { RecipesStore } from './recipes.store';

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.css']
})
export class RecipesComponent implements OnInit {

  recipes: Recipe[] = [];
  @Input() activeRecipe: Recipe = {} as Recipe



  constructor(
    public store: RecipesStore,
    private service: RecipesService
    ) { }

  ngOnInit(): void {
    this.service.readRecipe();
  }

  switchRecipe(form: NgForm){
    if(this.activeRecipe.id){
      this.updateRecipe(form)
    } else {
      this.createRecipe(form)
    }

  }

  updateRecipe(form: NgForm){
    const modRecipe: Recipe = {
      title: form.value.title,
      description: form.value.description,
      ingredients: form.value.ingredients,
      time: form.value.time,
      category: form.value.category,
      level: form.value.level,
    }
    this.service.updateRecipe(modRecipe);
  }

  createRecipe(form: NgForm){
    const newRecipe = {
      id: this.store.activeRecipe.id,
      title: form.value.title,
      description: form.value.description,
      ingredients: form.value.ingredients,
      time: form.value.time,
      category: form.value.category,
      level: form.value.level,
    }
    this.service.createRecipe(newRecipe);
  }

  delRecipe(recipe: Recipe){
      this.service.delRecipe(recipe);
  }

  setRecipe(recipe: Recipe) {
    this.service.setRecipe(recipe);
  }

  resetRecipe() {
    this.service.resetRecipe();
  }

}
