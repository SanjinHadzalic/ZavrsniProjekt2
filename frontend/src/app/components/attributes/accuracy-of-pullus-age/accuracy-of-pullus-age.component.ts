import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AccuracyOfPullusAgeService } from '../../../services/attributes/accuracy-of-pullus-age.service';
import { Router } from '@angular/router';
import { AccuracyOfPullusAge } from '../../../interfaces/attributes/accuracy-of-pullus-age';

@Component({
  selector: 'app-accuracy-of-pullus-age',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './accuracy-of-pullus-age.component.html',
  styleUrl: './accuracy-of-pullus-age.component.css',
})
export class AccuracyOfPullusAgeComponent implements OnInit {
  accuracyOfPullusAges: AccuracyOfPullusAge[] = [];

  constructor(
    private accuracyOfPullusAgeService: AccuracyOfPullusAgeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadAccuracyOfPullusAges();
  }

  loadAccuracyOfPullusAges(): void {
    this.accuracyOfPullusAgeService.getAllAccuracyOfPullusAges().subscribe(
      (data) => {
        this.accuracyOfPullusAges = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return() {
    this.router.navigate(['/attributes']);
  }
}
