import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FatScore } from '../../interfaces/attributes/fat-score';

@Injectable({
  providedIn: 'root'
})
export class FatScoreService {
  private baseUrl = 'http://localhost:8080/fatScore';

  constructor(private http: HttpClient) {}

  getAllFatScores(): Observable<FatScore[]> {
    return this.http.get<FatScore[]>(this.baseUrl);
  }

  getFatScore(id: number): Observable<FatScore> {
    return this.http.get<FatScore>(`${this.baseUrl}/${id}`);
  }
}