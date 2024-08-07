import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CatchingLures } from '../../interfaces/attributes/catching-lures';

@Injectable({
  providedIn: 'root'
})
export class CatchingLuresService {
  private apiUrl = 'http://localhost:8080/catchingLures';

  constructor(private http: HttpClient) {}

  getAllCatchingLures(): Observable<CatchingLures[]> {
    return this.http.get<CatchingLures[]>(this.apiUrl);
  }

  getCatchingLuresById(id: number): Observable<CatchingLures> {
    return this.http.get<CatchingLures>(`${this.apiUrl}/${id}`);
  }
}