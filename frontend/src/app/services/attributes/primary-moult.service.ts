import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PrimaryMoult } from '../../interfaces/attributes/primary-moult';

@Injectable({
  providedIn: 'root'
})
export class PrimaryMoultService {
  private baseUrl = 'http://localhost:8080/primaryMoult'; 

  constructor(private http: HttpClient) {}

  getAllPrimaryMoults(): Observable<PrimaryMoult[]> {
      return this.http.get<PrimaryMoult[]>(this.baseUrl);
  }

  getPrimaryMoultById(id: number): Observable<PrimaryMoult> {
      return this.http.get<PrimaryMoult>(`${this.baseUrl}/${id}`);
  }
}