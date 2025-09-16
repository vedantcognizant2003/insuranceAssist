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
    // console.log("calling");
    // const response = this.http.get(`http://localhost:8080/api/v1/public/login`, formValue);
    // console.log(response);
    // return response;

    // return this.http.post<{ token: string }>(
    //   `http://localhost:8080/api/v1/public/login`,
    //   formValue
    // );

    return this.http.post(`${environment.apiUrl}/public/login`, formValue); 

  }
}