import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MovedBeforeTheEncounter } from '../../interfaces/attributes/moved-before-the-encounter';

@Injectable({
  providedIn: 'root'
})
export class MovedBeforeTheEncounterService {
  private baseUrl = 'http://localhost:8080/movedBeforeTheEncounter';

  constructor(private http: HttpClient) {}

  getAllMovedBeforeTheEncounter(): Observable<MovedBeforeTheEncounter[]> {
    return this.http.get<MovedBeforeTheEncounter[]>(this.baseUrl);
  }

  getMovedBeforeTheEncounterById(id: number): Observable<MovedBeforeTheEncounter> {
    return this.http.get<MovedBeforeTheEncounter>(`${this.baseUrl}/${id}`);
  }
}