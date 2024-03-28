import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bird } from '../classes/bird.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BirdService {
  private basUrl = "http://localhost:8080/birds"

  constructor(private httpClient: HttpClient) { }

  getBirdList(): Observable<Bird[]> {
    return this.httpClient.get<Bird[]>(`${this.basUrl}`);
  }

  getBirdById(id: number): Observable<Bird> {
    return this.httpClient.get<Bird>(`${this.basUrl}/${id}`);
  } 
}
