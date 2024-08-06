import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApplicationUser } from '../interfaces/application-user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/auth/api/v1';
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, {username, password}, this.httpOptions);
  }

  logout(): Observable<any> {
    return this.http.post(`${this.baseUrl}/logout`, {}, this.httpOptions)
  }

  register(user: ApplicationUser): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/register`, user);
  }
}
