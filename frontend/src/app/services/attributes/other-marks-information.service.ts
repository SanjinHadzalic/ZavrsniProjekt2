import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OtherMarksInformation } from '../../interfaces/attributes/other-marks-information';

@Injectable({
  providedIn: 'root'
})
export class OtherMarksInformationService {
  private baseUrl = 'http://localhost:8080/otherMarksInformation';

  constructor(private http: HttpClient) {}

  getAllOtherMarksInformation(): Observable<OtherMarksInformation[]> {
    return this.http.get<OtherMarksInformation[]>(this.baseUrl);
  }

  getOtherMarksInformationById(id: number): Observable<OtherMarksInformation> {
    return this.http.get<OtherMarksInformation>(`${this.baseUrl}/${id}`);
  }
}