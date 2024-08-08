import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Place } from '../../interfaces/attributes/place';

@Injectable({
  providedIn: 'root'
})
export class PlaceService {
  private basUrl = "http://localhost:8080/place"
  constructor(private httpClient: HttpClient) { }

  getPlaceList(): Observable<Place[]> {
    return this.httpClient.get<Place[]>(`${this.basUrl}`);
  }

  getPlaceById(id: number): Observable<Place> {
    return this.httpClient.get<Place>(`${this.basUrl}/${id}`);
  }
  
  createPlace(place: Place): Observable<Place> {
    return this.httpClient.post<Place>(`${this.basUrl}`, place);
  }

  deletePlace(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.basUrl}/${id}`);
  }
  
}
