import { Component, OnInit } from '@angular/core';
import { PrimaryMoult } from '../../../interfaces/attributes/primary-moult';
import { PrimaryMoultService } from '../../../services/attributes/primary-moult.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-primary-moult',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './primary-moult.component.html',
  styleUrl: './primary-moult.component.css'
})
export class PrimaryMoultComponent implements OnInit {
  primaryMoults: PrimaryMoult[] = [];

  constructor(
      private primaryMoultService: PrimaryMoultService,
      private router: Router
  ) {}

  ngOnInit(): void {
      this.fetchPrimaryMoults();
  }

  fetchPrimaryMoults(): void {
      this.primaryMoultService.getAllPrimaryMoults().subscribe({
          next: (data) => {
              this.primaryMoults = data;
          },
          error: (err) => {
              console.error('Error fetching primary moults', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}