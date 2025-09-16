import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ReactiveFormsModule, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../../environments/environment.development';
import { LoginService } from '../../../core/services/login';


@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  loginForm: FormGroup = new FormGroup({
    username : new FormControl(""),
    password : new FormControl("")
  });

  router = inject(Router);
  loginService = inject(LoginService);
  private http = inject(HttpClient);

  onLogin() {
    const formValue = this.loginForm.value;
    // console.log(formValue);

    this.loginService.onLogin(formValue).subscribe({
      next: (response:any) => {
        
        if(response && response.token){
          localStorage.setItem('token', response.token);
          this.router.navigateByUrl("/dashboard/agent");
        }
        else{
          alert("Invalid response from server.");
        }
      },
      error: (error) => {
        alert(error.error);
      }
    });
  }
}

//   private http = inject(HttpClient);
//   onLogin() {
//     const formValue = this.loginForm.value;
//     this.http.post(`${environment.apiUrl}/auth/login`, formValue).subscribe({
//       next: (response:any) => {
//         // if(response.result) {
//         //   alert('Login Successful');
//         //   this.router.navigateByUrl("/dashboard/client");
//         // }else{
//         //   alert(response.message);
//         // } 

        
//         // const token = response.token;
//         // const decoded = parseJwt(token); // decode JWT to get role

//         // localStorage.setItem('token', token);
//         // localStorage.setItem('role', decoded.role);

//         // if (decoded.role === 'client') {
//         //   this.router.navigate(['/dashboard/client']);
//         // } else if (decoded.role === 'agent') {
//         //   this.router.navigate(['/dashboard/agent']);
//         // }

//         debugger;

//         localStorage.setItem("token",response.accessToken);

//         if(response!=null){
//           this.router.navigateByUrl("/dashboard/client");
//           // console.log(response);
//         }

//       },
//       error: (error) => {
//         debugger;
//         alert(error.error);
//       }
//     });
//   } 
// }
