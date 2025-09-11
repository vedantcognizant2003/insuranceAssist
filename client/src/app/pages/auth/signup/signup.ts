import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  imports: [ ReactiveFormsModule],
  templateUrl: './signup.html',
  styleUrl: './signup.css'
})
export class Signup {
  signupForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
      this.signupForm = this.fb.group({
          name: ['', Validators.required],
          username: ['', Validators.required],
          email: ['', [Validators.required, Validators.email]],
          dob: ['', Validators.required],
          phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
          gender: ['', Validators.required],
          address: ['', Validators.required],
          password: ['', [Validators.required, Validators.minLength(6)]],
      });
  }

  onSignup() {
      if (this.signupForm.valid) {
          this.http.post('/api/signup', this.signupForm.value).subscribe({
              next: () => { 
                  this.router.navigate(['/auth/dependents-nomination']);
              }
              , error: () => { console.error('Signup failed'); }
          });
      }
  }
}

