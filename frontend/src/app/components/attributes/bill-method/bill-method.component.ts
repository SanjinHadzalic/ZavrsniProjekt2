import { Component, OnInit } from '@angular/core';
import { BillMethodService } from '../../../services/attributes/bill-method.service';
import { Router } from '@angular/router';
import { BillMethod } from '../../../interfaces/attributes/bill-method';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bill-method',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bill-method.component.html',
  styleUrl: './bill-method.component.css'
})
export class BillMethodComponent implements OnInit {
  billMethods: BillMethod[] = [];

  constructor(private billMethodService: BillMethodService, private router: Router) {}

  ngOnInit(): void {
    this.loadBillMethods();
  }

  loadBillMethods(): void {
    this.billMethodService.getAllBillMethods().subscribe(
      (data) => {
        this.billMethods = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes'])
  }
}