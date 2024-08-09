import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Condition } from '../../interfaces/attributes/condition';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConditionService {
  private baseUrl = 'http://localhost:8080/condition';

  constructor(private http: HttpClient) {}

  getAllConditions(): Observable<Condition[]> {
    return this.http.get<Condition[]>(this.baseUrl);
  }

  getConditionById(id: number): Observable<Condition> {
    return this.http.get<Condition>(`${this.baseUrl}/${id}`);
  }
}