import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MetalRingInformation } from '../../interfaces/attributes/metal-ring-information';

@Injectable({
  providedIn: 'root',
})
export class MetalRingInformationService {
  private baseUrl = 'http://localhost:8080/metalRingInformation';

  constructor(private http: HttpClient) {}

  getAllMetalRingInformations(): Observable<MetalRingInformation[]> {
    return this.http.get<MetalRingInformation[]>(this.baseUrl);
  }

  getMetalRingInformationById(id: number): Observable<MetalRingInformation> {
    return this.http.get<MetalRingInformation>(`${this.baseUrl}/${id}`);
  }
}
