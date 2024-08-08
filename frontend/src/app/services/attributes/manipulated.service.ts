import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Manipulated } from '../../interfaces/attributes/manipulated';

@Injectable({
  providedIn: 'root'
})
export class ManipulatedService {
  private baseUrl = 'http://localhost:8080/manipulated';

  constructor(private http: HttpClient) {}

  getAllManipulated(): Observable<Manipulated[]> {
    return this.http.get<Manipulated[]>(this.baseUrl);
  }

  getManipulatedById(id: number): Observable<Manipulated> {
    return this.http.get<Manipulated>(`${this.baseUrl}/${id}`);
  }
}