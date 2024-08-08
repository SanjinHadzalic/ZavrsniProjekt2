import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sex } from '../../interfaces/attributes/sex';

@Injectable({
  providedIn: 'root'
})
export class SexService {
  private baseUrl = 'http://localhost:8080/sex'; 

  constructor(private http: HttpClient) {}

  getAllSexes(): Observable<Sex[]> {
      return this.http.get<Sex[]>(this.baseUrl);
  }

  getSexById(id: number): Observable<Sex> {
      return this.http.get<Sex>(`${this.baseUrl}/${id}`);
  }
}