import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RingCode } from '../../interfaces/attributes/ring-code';

@Injectable({
  providedIn: 'root'
})
export class RingCodeService {
  private baseUrl = 'http://localhost:8080/ringCode';

  constructor(private http: HttpClient) {}

  getAllRingCodes(): Observable<RingCode[]> {
    return this.http.get<RingCode[]>(`${this.baseUrl}`);
  }

  getRingCodesByUsernameAndEmail(username: string, email: string): Observable<RingCode[]> {
    return this.http.get<RingCode[]>(`${this.baseUrl}/user/${username}/email/${email}`);
  }

  getRingCodeById(id: number): Observable<RingCode> {
    return this.http.get<RingCode>(`${this.baseUrl}/${id}`);
  }

  generateNewRingCode(username: string, code: string, range: number, starter: string): Observable<RingCode[]> {
    const params = { username, code, range: range.toString(), starter };
    return this.http.post<RingCode[]>(`${this.baseUrl}/generate`, {}, { params });
  }

  updateRingCode(id: number, ringCode: RingCode): Observable<RingCode> {
    return this.http.put<RingCode>(`${this.baseUrl}/${id}`, ringCode);
  }

  deleteRingCodeById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}