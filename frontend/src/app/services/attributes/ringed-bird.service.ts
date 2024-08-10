import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RingedBird } from '../../interfaces/attributes/ringed-bird';

@Injectable({
  providedIn: 'root'
})
export class RingedBirdService {
  private apiUrl = 'http://localhost:8080/ringedBird';

  constructor(private http: HttpClient) {}

  getAllRingedBirds(): Observable<RingedBird[]> {
    return this.http.get<RingedBird[]>(`${this.apiUrl}`);
  }

  getRingedBirdById(id: number): Observable<RingedBird> {
    return this.http.get<RingedBird>(`${this.apiUrl}/${id}`);
  }

  getRingedBirdByCode(rCode: string): Observable<RingedBird> {
    return this.http.get<RingedBird>(`${this.apiUrl}/code/${rCode}`)
  }

  getAllRingedBirdsByCode(rCode: string): Observable<RingedBird[]> {
    return this.http.get<RingedBird[]>(`${this.apiUrl}/ringCode/${rCode}`);
  }

  getAllRingedBirdsByUser(username: string): Observable<RingedBird[]> {
    return this.http.get<RingedBird[]>(`${this.apiUrl}/user/${username}`);
  }

  createRingedBird(ringedBird: RingedBird): Observable<RingedBird> {
    return this.http.post<RingedBird>(`${this.apiUrl}`, ringedBird);
  }

  createNewRingedBirdFromExisting(rCode: string, ringedBird: RingedBird): Observable<RingedBird> {
    return this.http.post<RingedBird>(`${this.apiUrl}/ringCode/${rCode}`, ringedBird);
  }

  updateRingedBird(id: number, ringedBird: RingedBird): Observable<RingedBird> {
    return this.http.put<RingedBird>(`${this.apiUrl}/${id}`, ringedBird);
  }

  deleteRingedBird(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  searchRingedBirds(filters: any): Observable<RingedBird[]> {
    let params = new HttpParams();

    // Add each filter to the parameters if it has a value
    for (const key in filters) {
      if (filters[key]) {
        params = params.append(key, filters[key]);
      }
    }

    return this.http.get<RingedBird[]>(`${this.apiUrl}/search`, { params });
  }
}