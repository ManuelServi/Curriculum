import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, of, tap } from 'rxjs';
import { Login } from 'src/app/core/model/login.model';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }


  ngOnInit(): void {
  }

  login(form: NgForm) {
    const login: Login ={
      username: form.value.username,
      password: form.value.password,
    }
    const url = environment.baseUrl+"/auth/signin"
    this.httpClient.post<any>(url, login, {
      headers: new HttpHeaders({
        "Content-Type": "application/json"
      }),
      observe: "response"
    })
      .pipe(catchError( error => {
        console.log(error);
        return of()
      }))
      .pipe( tap( r => {
        console.log(r)
        console.log(r.headers.get('Set-Cookie'))
        console.log(r.headers)
        // localStorage.setItem("token", r.accessToken);
        this.router.navigate(["recipes"])
    })).subscribe( () => {})
  }

}
