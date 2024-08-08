import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PrimaryIdentificationMethod } from '../../../interfaces/attributes/primary-identification-method';
import { PrimaryIdentificationMethodService } from '../../../services/attributes/primary-identification-method.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-primary-identification-method',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './primary-identification-method.component.html',
  styleUrl: './primary-identification-method.component.css'
})
export class PrimaryIdentificationMethodComponent implements OnInit {
  primaryIdentificationMethods: PrimaryIdentificationMethod[] = [];

  constructor(
      private primaryIdentificationMethodService: PrimaryIdentificationMethodService,
      private router: Router
  ) {}

  ngOnInit(): void {
      this.fetchPrimaryIdentificationMethods();
  }

  fetchPrimaryIdentificationMethods(): void {
      this.primaryIdentificationMethodService.getAllPrimaryIdentificationMethods().subscribe({
          next: (data) => {
              this.primaryIdentificationMethods = data;
          },
          error: (err) => {
              console.error('Error fetching primary identification methods', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}