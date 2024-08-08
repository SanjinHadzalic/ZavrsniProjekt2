import { Component, OnInit } from '@angular/core';
import { SexingMethod } from '../../../interfaces/attributes/sexing-method';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { SexingMethodService } from '../../../services/attributes/sexing-method.service';

@Component({
  selector: 'app-sexing-method',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sexing-method.component.html',
  styleUrl: './sexing-method.component.css'
})
export class SexingMethodComponent implements OnInit {
  sexingMethods: SexingMethod[] = [];

  constructor(private sexingMethodService: SexingMethodService, private router: Router) {}

  ngOnInit(): void {
      this.fetchSexingMethods();
  }

  fetchSexingMethods(): void {
      this.sexingMethodService.getAllSexingMethods().subscribe({
          next: (data) => {
              this.sexingMethods = data;
          },
          error: (err) => {
              console.error('Error fetching sexing methods', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}
