import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccuracyOfDate } from '../../interfaces/attributes/accuracy-of-date';

@Injectable({
  providedIn: 'root'
})
export class AccuracyOfDateService {
  private apiUrl = 'http://localhost:8080/accuracyOfDate'; 

  constructor(private http: HttpClient) {}

  getAllAccuracyOfDates(): Observable<AccuracyOfDate[]> {
    return this.http.get<AccuracyOfDate[]>(this.apiUrl);
  }

  getAccuracyOfDateById(id: number): Observable<AccuracyOfDate> {
    return this.http.get<AccuracyOfDate>(`${this.apiUrl}/${id}`);
  }
}