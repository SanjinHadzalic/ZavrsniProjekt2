import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarpalCovert } from '../../interfaces/attributes/carpal-covert';

@Injectable({
  providedIn: 'root'
})
export class CarpalCovertService {
  private apiUrl = 'http://localhost:8080/carpalCovert'; 

  constructor(private http: HttpClient) {}

  getAllCarpalCoverts(): Observable<CarpalCovert[]> {
    return this.http.get<CarpalCovert[]>(this.apiUrl);
  }

  getCarpalCovertById(id: number): Observable<CarpalCovert> {
    return this.http.get<CarpalCovert>(`${this.apiUrl}/${id}`);
  }
}