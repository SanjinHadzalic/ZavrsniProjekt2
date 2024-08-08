import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Status } from '../../interfaces/attributes/status';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  private baseUrl = 'http://localhost:8080/status'; 

  constructor(private http: HttpClient) {}

  getAllStatuses(): Observable<Status[]> {
      return this.http.get<Status[]>(this.baseUrl);
  }

  getStatusById(id: number): Observable<Status> {
      return this.http.get<Status>(`${this.baseUrl}/${id}`);
  }
}