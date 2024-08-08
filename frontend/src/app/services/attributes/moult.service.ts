import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Moult } from '../../interfaces/attributes/moult';

@Injectable({
  providedIn: 'root'
})
export class MoultService {
  private baseUrl = 'http://localhost:8080/moult';

  constructor(private http: HttpClient) {}

  getAllMoults(): Observable<Moult[]> {
    return this.http.get<Moult[]>(this.baseUrl);
  }

  getMoultById(id: number): Observable<Moult> {
    return this.http.get<Moult>(`${this.baseUrl}/${id}`);
  }
}