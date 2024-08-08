import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StateOfWingPoint } from '../../interfaces/attributes/state-of-wing-point';

@Injectable({
  providedIn: 'root'
})
export class StateOfWingPointService {
  private baseUrl = 'http://localhost:8080/stateOfWingPoint';

  constructor(private http: HttpClient) {}

  getAllStateOfWingPoints(): Observable<StateOfWingPoint[]> {
      return this.http.get<StateOfWingPoint[]>(this.baseUrl);
  }

  getStateOfWingPointById(id: number): Observable<StateOfWingPoint> {
      return this.http.get<StateOfWingPoint>(`${this.baseUrl}/${id}`);
  }
}