import { Component, OnInit } from '@angular/core';
import { AccuracyOfDateService } from '../../../services/attributes/accuracy-of-date.service';
import { CommonModule } from '@angular/common';
import { AccuracyOfDate } from '../../../interfaces/attributes/accuracy-of-date';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accuracy-of-date',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './accuracy-of-date.component.html',
  styleUrl: './accuracy-of-date.component.css'
})
export class AccuracyOfDateComponent implements OnInit {
  accuracyOfDates: AccuracyOfDate[] = [];

  constructor(private accuracyOfDateService: AccuracyOfDateService, private router: Router) {}

  ngOnInit(): void {
    this.loadAccuracyOfDates();
  }

  loadAccuracyOfDates(): void {
    this.accuracyOfDateService.getAllAccuracyOfDates().subscribe(
      (data) => {
        this.accuracyOfDates = data;
      },
      (error) => {
        console.error('Error fetching accuracy of dates', error);
      }
    );
  }

  return() {
    this.router.navigate(['/attributes'])
  }
}
