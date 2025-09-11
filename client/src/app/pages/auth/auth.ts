import { Component } from '@angular/core';
import { Login } from './login/login';
import { Signup } from './signup/signup';

@Component({
  selector: 'app-auth',
  imports: [Login, Signup],
  templateUrl: './auth.html',
  styleUrl: './auth.css'
})
export class Auth {
  selectedTab: 'login' | 'register' = 'login';
  selectTab(tab: 'login' | 'register') {
    this.selectedTab = tab;
  }
}
