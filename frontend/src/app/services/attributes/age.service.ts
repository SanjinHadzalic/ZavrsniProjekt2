import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Age } from '../../interfaces/attributes/age';

@Injectable({
  providedIn: 'root'
})
export class AgeService {
  private apiUrl = 'http://localhost:8080/age'; // Update with your backend API URL

  constructor(private http: HttpClient) {}

  getAllAges(): Observable<Age[]> {
    return this.http.get<Age[]>(this.apiUrl);
  }

  getAgeById(id: number): Observable<Age> {
    return this.http.get<Age>(`${this.apiUrl}/${id}`);
  }
}
