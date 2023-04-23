import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/authentication/auth.guard';
import { LoginComponent } from './features/login/login.component';
import { RecipesComponent } from './features/recipes/recipes.component';
import { RegisterComponent } from './features/register/register.component';

const routes: Routes = [{
  path: "login", component: LoginComponent
}, {
  path: "register", component: RegisterComponent
}, {
  path: "recipes", component: RecipesComponent, canActivate: [AuthGuard]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
