import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PlumageCode } from '../../interfaces/attributes/plumage-code';

@Injectable({
  providedIn: 'root'
})
export class PlumageCodeService {
  private baseUrl = 'http://localhost:8080/plumageCode'; 

  constructor(private http: HttpClient) {}

  getAllPlumageCodes(): Observable<PlumageCode[]> {
      return this.http.get<PlumageCode[]>(this.baseUrl);
  }

  getPlumageCodeById(id: number): Observable<PlumageCode> {
      return this.http.get<PlumageCode>(`${this.baseUrl}/${id}`);
  }
}