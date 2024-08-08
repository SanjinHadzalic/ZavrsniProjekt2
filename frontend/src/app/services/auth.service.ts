import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { ApplicationUser } from '../interfaces/application-user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/auth/api/v1';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(
      `${this.baseUrl}/login`,
      { username, password },
      this.httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(`${this.baseUrl}/logout`, {}, this.httpOptions);
  }

  register(user: ApplicationUser): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/register`, user);
  }

  refreshToken(): Observable<any> {
    const refreshToken = localStorage.getItem('jwtToken');

    if (!refreshToken) {
      console.error('No refresh token found');
      return throwError(() => new Error('No refresh token found!'));
    }

    const body = { token: refreshToken };

    console.log('123')



    return this.http.post<any>(`${this.baseUrl}/refreshToken`, body)
      .pipe(
        tap((response) => {
          if ( response.token) {
            localStorage.setItem('accessToken', response.accessToken);
            localStorage.setItem('jwtToken', response.token);
          } else {
            console.error('Invalid token response:', response);
            localStorage.clear();
          }
        }),
        catchError((error) => {
          console.error('Error during token refresh:', error);
          localStorage.clear();
          return throwError(error);
        })
      );
  }}
