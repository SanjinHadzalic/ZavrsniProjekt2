import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CircumstancesPresumed } from '../../interfaces/attributes/circumstances-presumed';

@Injectable({
  providedIn: 'root'
})
export class CircumstancesPresumedService {
  private apiUrl = 'http://localhost:8080/circumstancesPresumed'; 

  constructor(private http: HttpClient) {}

  getAllCircumstancesPresumed(): Observable<CircumstancesPresumed[]> {
    return this.http.get<CircumstancesPresumed[]>(this.apiUrl);
  }

  getCircumstancesPresumedById(id: number): Observable<CircumstancesPresumed> {
    return this.http.get<CircumstancesPresumed>(`${this.apiUrl}/${id}`);
  }
}