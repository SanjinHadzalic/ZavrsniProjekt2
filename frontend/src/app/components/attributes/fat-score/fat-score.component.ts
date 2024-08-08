import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FatScoreService } from '../../../services/attributes/fat-score.service';
import { FatScore } from '../../../interfaces/attributes/fat-score';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-fat-score',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './fat-score.component.html',
  styleUrl: './fat-score.component.css',
})
export class FatScoreComponent implements OnInit {
  fatScores: FatScore[] = [];

  constructor(
    private fatScoreService: FatScoreService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchFatScores();
  }

  fetchFatScores(): void {
    this.fatScoreService.getAllFatScores().subscribe({
      next: (data) => {
        this.fatScores = data;
      },
      error: (err) => {
        console.error('Error fetching fat scores', err);
      },
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}
