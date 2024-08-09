import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PullusAge } from '../../../interfaces/attributes/pullus-age';
import { PullusAgeService } from '../../../services/attributes/pullus-age.service';

@Component({
  selector: 'app-pullus-age',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pullus-age.component.html',
  styleUrl: './pullus-age.component.css'
})
export class PullusAgeComponent implements OnInit {
  pullusAges: PullusAge[] = [];

  constructor(private pullusAgeService: PullusAgeService, private router: Router) {}

  ngOnInit(): void {
    this.loadPullusAges();
  }

  loadPullusAges(): void {
    this.pullusAgeService.getAllPullusAges().subscribe(data => {
      this.pullusAges = data;
    });
  }

  viewDetails(id: number): void {
    this.router.navigate(['/pullusAge', id]);
  }

  return(): void {
    this.router.navigate(['/attributes']);
  }
}