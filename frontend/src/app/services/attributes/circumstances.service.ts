import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Circumstances } from '../../interfaces/attributes/circumstances';

@Injectable({
  providedIn: 'root'
})
export class CircumstancesService {
  private apiUrl = 'http://localhost:8080/circumstances'; 

  constructor(private http: HttpClient) {}

  getAllCircumstances(): Observable<Circumstances[]> {
    return this.http.get<Circumstances[]>(this.apiUrl);
  }

  getCircumstancesById(id: number): Observable<Circumstances> {
    return this.http.get<Circumstances>(`${this.apiUrl}/${id}`);
  }
}