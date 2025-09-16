import { Component, inject } from '@angular/core';
import { Login } from './login/login';
import { Signup } from './signup/signup';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  imports: [Login, Signup],
  templateUrl: './auth.html',
  styleUrl: './auth.css'
})
export class Auth {

  router = inject(Router);
  constructor() {
    if(localStorage.getItem('token')){
      this.router.navigateByUrl("/dashboard/client") ;
    }
  }

  selectedTab: 'login' | 'register' = 'login';
  selectTab(tab: 'login' | 'register') {
    this.selectedTab = tab;


  }
}
