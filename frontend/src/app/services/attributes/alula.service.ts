import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alula } from '../../interfaces/attributes/alula';

@Injectable({
  providedIn: 'root'
})
export class AlulaService {
  private apiUrl = 'http://localhost:8080/alula'; // Update with your backend API URL

  constructor(private http: HttpClient) {}

  getAllAlulas(): Observable<Alula[]> {
    return this.http.get<Alula[]>(this.apiUrl);
  }

  getAlulaById(id: number): Observable<Alula> {
    return this.http.get<Alula>(`${this.apiUrl}/${id}`);
  }
}