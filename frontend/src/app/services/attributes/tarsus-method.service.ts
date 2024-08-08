import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TarsusMethod } from '../../interfaces/attributes/tarsus-method';

@Injectable({
  providedIn: 'root'
})
export class TarsusMethodService {
  private baseUrl = 'http://localhost:8080/tarsusMethod'; 

  constructor(private http: HttpClient) {}

  getAllTarsusMethods(): Observable<TarsusMethod[]> {
      return this.http.get<TarsusMethod[]>(this.baseUrl);
  }

  getTarsusMethodById(id: number): Observable<TarsusMethod> {
      return this.http.get<TarsusMethod>(`${this.baseUrl}/${id}`);
  }
}