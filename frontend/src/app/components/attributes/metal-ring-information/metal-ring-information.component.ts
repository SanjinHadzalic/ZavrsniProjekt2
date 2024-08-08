import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MetalRingInformation } from '../../../interfaces/attributes/metal-ring-information';
import { MetalRingInformationService } from '../../../services/attributes/metal-ring-information.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-metal-ring-information',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './metal-ring-information.component.html',
  styleUrl: './metal-ring-information.component.css'
})
export class MetalRingInformationComponent implements OnInit {
  metalRingInformations: MetalRingInformation[] = [];
  
  constructor(private metalRingInformationService: MetalRingInformationService, private router: Router) {}

  ngOnInit(): void {
    this.fetchMetalRingInformations();
  }

  fetchMetalRingInformations(): void {
    this.metalRingInformationService.getAllMetalRingInformations().subscribe({
      next: (data) => {
        this.metalRingInformations = data;
      },
      error: (err) => {
        console.error('Error fetching metal ring information', err);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}