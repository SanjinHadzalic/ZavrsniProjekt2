import { Component, OnInit } from '@angular/core';
import { AgeService } from '../../../services/attributes/age.service';
import { Router } from '@angular/router';
import { Age } from '../../../interfaces/attributes/age';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-age',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './age.component.html',
  styleUrls: ['./age.component.css'],
})
export class AgeComponent implements OnInit {
  ages: Age[] = [];

  constructor(private ageService: AgeService, private router: Router) {}

  ngOnInit(): void {
    this.loadAges();
  }

  loadAges(): void {
    this.ageService.getAllAges().subscribe(
      (data) => {
        this.ages = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes'])
  }
}
