import { Component, OnInit } from '@angular/core';
import { VerificationOfTheMetalRing } from '../../../interfaces/attributes/verification-of-the-metal-ring';
import { VerificationOfTheMetalRingService } from '../../../services/attributes/verification-of-the-metal-ring.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-verification-of-the-metal-ring',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './verification-of-the-metal-ring.component.html',
  styleUrl: './verification-of-the-metal-ring.component.css'
})
export class VerificationOfTheMetalRingComponent implements OnInit {
  verificationOfTheMetalRings: VerificationOfTheMetalRing[] = [];

  constructor(
      private verificationOfTheMetalRingService: VerificationOfTheMetalRingService,
      private router: Router
  ) {}

  ngOnInit(): void {
      this.fetchVerificationOfTheMetalRings();
  }

  fetchVerificationOfTheMetalRings(): void {
      this.verificationOfTheMetalRingService.getAllVerificationOfTheMetalRings().subscribe({
          next: (data) => {
              this.verificationOfTheMetalRings = data;
          },
          error: (err) => {
              console.error('Error fetching verification of the metal rings', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}