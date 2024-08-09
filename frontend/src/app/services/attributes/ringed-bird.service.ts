import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RingedBird } from '../../interfaces/attributes/ringed-bird';

@Injectable({
  providedIn: 'root'
})
export class RingedBirdService {
  private apiUrl = 'http://localhost:8080/ringedBird';

  constructor(private http: HttpClient) {}

  getAllRingedBirds(): Observable<RingedBird[]> {
    return this.http.get<RingedBird[]>(`${this.apiUrl}`);
  }

  getRingedBirdById(id: number): Observable<RingedBird> {
    return this.http.get<RingedBird>(`${this.apiUrl}/${id}`);
  }

  createRingedBird(ringedBird: RingedBird): Observable<RingedBird> {
    return this.http.post<RingedBird>(this.apiUrl, ringedBird);
  }

  updateRingedBird(id: number, ringedBird: RingedBird): Observable<RingedBird> {
    return this.http.put<RingedBird>(`${this.apiUrl}/${id}`, ringedBird);
  }

  deleteRingedBird(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}