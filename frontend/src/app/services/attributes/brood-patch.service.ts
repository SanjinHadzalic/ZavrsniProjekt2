import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BroodPatch } from '../../interfaces/attributes/brood-patch';

@Injectable({
  providedIn: 'root'
})
export class BroodPatchService {
  private apiUrl = 'http://localhost:8080/broodPatch';

  constructor(private http: HttpClient) {}

  getAllBroodPatches(): Observable<BroodPatch[]> {
    return this.http.get<BroodPatch[]>(this.apiUrl);
  }

  getBroodPatchById(id: number): Observable<BroodPatch> {
    return this.http.get<BroodPatch>(`${this.apiUrl}/${id}`);
  }
}
