import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BroodSize } from '../../interfaces/attributes/brood-size';

@Injectable({
  providedIn: 'root'
})
export class BroodSizeService {
  private apiUrl = 'http://localhost:8080/broodSize'; 

  constructor(private http: HttpClient) {}

  getAllBroodSizes(): Observable<BroodSize[]> {
    return this.http.get<BroodSize[]>(this.apiUrl);
  }

  getBroodSizeById(id: number): Observable<BroodSize> {
    return this.http.get<BroodSize>(`${this.apiUrl}/${id}`);
  }
}