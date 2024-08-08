import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { StateOfWingPoint } from '../../../interfaces/attributes/state-of-wing-point';
import { StateOfWingPointService } from '../../../services/attributes/state-of-wing-point.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-state-of-wing-point',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './state-of-wing-point.component.html',
  styleUrl: './state-of-wing-point.component.css'
})
export class StateOfWingPointComponent implements OnInit {
  stateOfWingPoints: StateOfWingPoint[] = [];

  constructor(private stateOfWingPointService: StateOfWingPointService, private router: Router) {}

  ngOnInit(): void {
      this.fetchStateOfWingPoints();
  }

  fetchStateOfWingPoints(): void {
      this.stateOfWingPointService.getAllStateOfWingPoints().subscribe({
          next: (data) => {
              this.stateOfWingPoints = data;
          },
          error: (err) => {
              console.error('Error fetching state of wing points', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}