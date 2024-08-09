import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PullusAge } from '../../interfaces/attributes/pullus-age';

@Injectable({
  providedIn: 'root'
})
export class PullusAgeService {
  private baseUrl = 'http://localhost:8080/pullusAge';

  constructor(private http: HttpClient) {}

  getAllPullusAges(): Observable<PullusAge[]> {
    return this.http.get<PullusAge[]>(this.baseUrl);
  }

  getPullusAgeById(id: number): Observable<PullusAge> {
    return this.http.get<PullusAge>(`${this.baseUrl}/${id}`);
  }
}