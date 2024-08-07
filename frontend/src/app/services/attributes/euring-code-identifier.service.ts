import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EuringCodeIdentifier } from '../../interfaces/attributes/euring-code-identifier';

@Injectable({
  providedIn: 'root'
})
export class EURINGCodeIdentifierService {
  private apiUrl = 'http://localhost:8080/euring_code_identifier'; 

  constructor(private http: HttpClient) {}

  getAllEURINGCodeIdentifier(): Observable<EuringCodeIdentifier[]> {
    return this.http.get<EuringCodeIdentifier[]>(this.apiUrl);
  }

  getEURINGCodeIdentifierById(id: number): Observable<EuringCodeIdentifier> {
    return this.http.get<EuringCodeIdentifier>(`${this.apiUrl}/${id}`);
  }
}