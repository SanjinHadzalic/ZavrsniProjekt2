import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PrimaryIdentificationMethod } from '../../interfaces/attributes/primary-identification-method';

@Injectable({
  providedIn: 'root'
})
export class PrimaryIdentificationMethodService {
  private baseUrl = 'http://localhost:8080/primaryIdentificationMethod';

  constructor(private http: HttpClient) {}

  getAllPrimaryIdentificationMethods(): Observable<PrimaryIdentificationMethod[]> {
      return this.http.get<PrimaryIdentificationMethod[]>(this.baseUrl);
  }

  getPrimaryIdentificationMethodById(id: number): Observable<PrimaryIdentificationMethod> {
      return this.http.get<PrimaryIdentificationMethod>(`${this.baseUrl}/${id}`);
  }
}