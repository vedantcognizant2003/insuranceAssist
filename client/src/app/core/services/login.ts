import { inject, Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../../../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private http = inject(HttpClient);


  onLogin(formValue: any): Observable<any> {
   

    return this.http.post(`${environment.apiUrl}/public/login`, formValue); 

    // return this.http.post(`${environment.apiUrl}/auth/login`, formValue);

  }
}