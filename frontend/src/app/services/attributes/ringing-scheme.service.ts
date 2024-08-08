import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RingingScheme } from '../../interfaces/attributes/ringing-scheme';

@Injectable({
  providedIn: 'root'
})
export class RingingSchemeService {
  private baseUrl = 'http://localhost:8080/ringingScheme'; 

  constructor(private http: HttpClient) {}

  getAllRingingSchemes(): Observable<RingingScheme[]> {
      return this.http.get<RingingScheme[]>(this.baseUrl);
  }

  getRingingSchemeById(id: number): Observable<RingingScheme> {
      return this.http.get<RingingScheme>(`${this.baseUrl}/${id}`);
  }

  saveRingingScheme(ringingScheme: RingingScheme): Observable<RingingScheme> {
      return this.http.post<RingingScheme>(this.baseUrl, ringingScheme);
  }

  updateRingingScheme(id: number, ringingScheme: RingingScheme): Observable<RingingScheme> {
      return this.http.put<RingingScheme>(`${this.baseUrl}/${id}`, ringingScheme);
  }

  deleteRingingScheme(id: number): Observable<void> {
      return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}