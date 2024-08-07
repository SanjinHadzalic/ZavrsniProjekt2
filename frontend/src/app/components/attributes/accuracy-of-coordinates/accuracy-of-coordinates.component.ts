import { Component, OnInit } from '@angular/core';
import { AccuracyOfCoordinatesService } from '../../../services/attributes/accuracy-of-coordinates.service';
import { CommonModule } from '@angular/common';
import { AccuracyOfCoordinates } from '../../../interfaces/attributes/accuracy-of-coordinates';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accuracy-of-coordinates',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './accuracy-of-coordinates.component.html',
  styleUrl: './accuracy-of-coordinates.component.css',
})
export class AccuracyOfCoordinatesComponent implements OnInit {
  accuracyOfCoordinates: AccuracyOfCoordinates[] = [];

  constructor(
    private accuracyOfCoordinatesService: AccuracyOfCoordinatesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchAccuracyOfCoordinates();
  }

  fetchAccuracyOfCoordinates(): void {
    this.accuracyOfCoordinatesService.getAllAccuracyOfCoordinates().subscribe({
      next: (data) => {
        this.accuracyOfCoordinates = data;
      },
      error: (error) => {
        console.error('Error fetching accuracy of coordinates:', error);
      },
    });
  }

  return() {
    this.router.navigate(['/attributes']);
  }
}
