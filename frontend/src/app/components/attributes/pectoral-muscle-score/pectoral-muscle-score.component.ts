import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PectoralMuscleScore } from '../../../interfaces/attributes/pectoral-muscle-score';
import { PectoralMuscleScoreService } from '../../../services/attributes/pectoral-muscle-score.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pectoral-muscle-score',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pectoral-muscle-score.component.html',
  styleUrl: './pectoral-muscle-score.component.css'
})
export class PectoralMuscleScoreComponent implements OnInit {
  pectoralMuscleScores: PectoralMuscleScore[] = [];

  constructor(
    private pectoralMuscleScoreService: PectoralMuscleScoreService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchPectoralMuscleScores();
  }

  fetchPectoralMuscleScores(): void {
    this.pectoralMuscleScoreService.getAllPectoralMuscleScores().subscribe({
      next: (data) => {
        this.pectoralMuscleScores = data;
      },
      error: (err) => {
        console.error('Error fetching pectoral muscle scores', err);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}