import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CatchingMethods } from '../../interfaces/attributes/catching-methods';

@Injectable({
  providedIn: 'root'
})
export class CatchingMethodsService {
  private apiUrl = 'http://localhost:8080/catchingMethods'; 

  constructor(private http: HttpClient) {}

  getAllCatchingMethods(): Observable<CatchingMethods[]> {
    return this.http.get<CatchingMethods[]>(this.apiUrl);
  }

  getCatchingMethodsById(id: number): Observable<CatchingMethods> {
    return this.http.get<CatchingMethods>(`${this.apiUrl}/${id}`);
  }
}