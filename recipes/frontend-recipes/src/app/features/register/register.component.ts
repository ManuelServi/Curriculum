import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, of } from 'rxjs';
import { Register } from 'src/app/core/model/register.model';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  ngOnInit(): void { }

  register(form: NgForm) {
    const register1: Register = {
      username: form.value.username,
      password: form.value.password,
      email: form.value.email,
      role: [form.value.role]
    }
    const url = environment.baseUrl+"/auth/signup"
    const headers= new HttpHeaders()
      .set('content-type', 'application/json')


    this.httpClient.post<any>(url, register1, {'headers': headers })
    .pipe(catchError(error => {console.log(error); return of ()}))
      .subscribe( r => {
        localStorage.setItem("token", r.accessToken);
        this.router.navigate(["search", "cart"])
      })
  }

}
