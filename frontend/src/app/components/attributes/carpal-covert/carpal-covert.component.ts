import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarpalCovertService } from '../../../services/attributes/carpal-covert.service';
import { CarpalCovert } from '../../../interfaces/attributes/carpal-covert';

@Component({
  selector: 'app-carpal-covert',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carpal-covert.component.html',
  styleUrl: './carpal-covert.component.css'
})
export class CarpalCovertComponent implements OnInit {
  carpalCoverts: CarpalCovert[] = [];

  constructor(private carpalCovertService: CarpalCovertService, private router: Router) {}

  ngOnInit(): void {
    this.loadCarpalCoverts();
  }

  loadCarpalCoverts(): void {
    this.carpalCovertService.getAllCarpalCoverts().subscribe(
      (data) => {
        this.carpalCoverts = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes']); 
  }
}