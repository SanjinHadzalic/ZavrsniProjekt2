import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccuracyOfPullusAge } from '../../interfaces/attributes/accuracy-of-pullus-age';

@Injectable({
  providedIn: 'root'
})
export class AccuracyOfPullusAgeService {
  private apiUrl = 'http://localhost:8080/accuracyOfPullusAge';

  constructor(private http: HttpClient) {}

  getAllAccuracyOfPullusAges(): Observable<AccuracyOfPullusAge[]> {
    return this.http.get<AccuracyOfPullusAge[]>(this.apiUrl);
  }

  getAccuracyOfPullusAgeById(id: number): Observable<AccuracyOfPullusAge> {
    return this.http.get<AccuracyOfPullusAge>(`${this.apiUrl}/${id}`);
  }
}