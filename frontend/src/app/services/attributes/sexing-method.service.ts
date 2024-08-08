import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SexingMethod } from '../../interfaces/attributes/sexing-method';

@Injectable({
  providedIn: 'root'
})
export class SexingMethodService {
  private baseUrl = 'http://localhost:8080/sexingMethod'; 

  constructor(private http: HttpClient) {}

  getAllSexingMethods(): Observable<SexingMethod[]> {
      return this.http.get<SexingMethod[]>(this.baseUrl);
  }

  getSexingMethodById(id: number): Observable<SexingMethod> {
      return this.http.get<SexingMethod>(`${this.baseUrl}/${id}`);
  }
}