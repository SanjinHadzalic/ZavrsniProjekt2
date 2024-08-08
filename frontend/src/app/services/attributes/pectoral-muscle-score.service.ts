import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PectoralMuscleScore } from '../../interfaces/attributes/pectoral-muscle-score';

@Injectable({
  providedIn: 'root'
})
export class PectoralMuscleScoreService {
  private baseUrl = 'http://localhost:8080/pectoralMuscleScore';

  constructor(private http: HttpClient) {}

  getAllPectoralMuscleScores(): Observable<PectoralMuscleScore[]> {
    return this.http.get<PectoralMuscleScore[]>(this.baseUrl);
  }

  getPectoralMuscleScoreById(id: number): Observable<PectoralMuscleScore> {
    return this.http.get<PectoralMuscleScore>(`${this.baseUrl}/${id}`);
  }
}