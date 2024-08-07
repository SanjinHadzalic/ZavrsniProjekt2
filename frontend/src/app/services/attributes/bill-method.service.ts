import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BillMethod } from '../../interfaces/attributes/bill-method';

@Injectable({
  providedIn: 'root'
})
export class BillMethodService {
  private apiUrl = 'http://localhost:8080/billMethod'; // Update with your backend API URL

  constructor(private http: HttpClient) {}

  getAllBillMethods(): Observable<BillMethod[]> {
    return this.http.get<BillMethod[]>(this.apiUrl);
  }

  getBillMethodById(id: number): Observable<BillMethod> {
    return this.http.get<BillMethod>(`${this.apiUrl}/${id}`);
  }
}
