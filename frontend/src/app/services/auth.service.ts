import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap, throwError } from 'rxjs';
import { ApplicationUser } from '../interfaces/application-user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/auth/api/v1';
  private usersUrl = 'http://localhost:8080/users';
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

    const body = {
      refreshToken: refreshToken,
      expiredAccessToken: localStorage.getItem('jwtToken'),
    };

    return this.http.post<any>(`${this.refreshToken}`, body).pipe(
      tap((response) => {
        if (response && response.tokens) {
          localStorage.setItem('accessToken', response.tokens.accessToken);
          localStorage.setItem('jwtToken', response.tokens.token);
        }
      })
    );
  }

  // getUserByUsername(username: string): Observable<ApplicationUser> {
  //   return this.http.get<ApplicationUser>(`${this.usersUrl}/${username}`, this.httpOptions);
  // }
}
