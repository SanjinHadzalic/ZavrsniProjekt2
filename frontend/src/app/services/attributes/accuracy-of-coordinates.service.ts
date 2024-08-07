import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccuracyOfCoordinates } from '../../interfaces/attributes/accuracy-of-coordinates';

@Injectable({
  providedIn: 'root'
})
export class AccuracyOfCoordinatesService {

  private baseUrl = 'http://localhost:8080/accuracyOfCoordinates'; 

  constructor(private http: HttpClient) {}

  getAllAccuracyOfCoordinates(): Observable<AccuracyOfCoordinates[]> {
    return this.http.get<AccuracyOfCoordinates[]>(this.baseUrl);
  }

  getAccuracyOfCoordinatesById(id: number): Observable<AccuracyOfCoordinates> {
    return this.http.get<AccuracyOfCoordinates>(`${this.baseUrl}/${id}`);
  }}
