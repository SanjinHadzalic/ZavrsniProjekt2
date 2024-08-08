import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VerificationOfTheMetalRing } from '../../interfaces/attributes/verification-of-the-metal-ring';

@Injectable({
  providedIn: 'root'
})
export class VerificationOfTheMetalRingService {
  private baseUrl = 'http://localhost:8080/verificationOfTheMetalRing'; 

  constructor(private http: HttpClient) {}

  getAllVerificationOfTheMetalRings(): Observable<VerificationOfTheMetalRing[]> {
      return this.http.get<VerificationOfTheMetalRing[]>(this.baseUrl);
  }

  getVerificationOfTheMetalRingById(id: number): Observable<VerificationOfTheMetalRing> {
      return this.http.get<VerificationOfTheMetalRing>(`${this.baseUrl}/${id}`);
  }
}