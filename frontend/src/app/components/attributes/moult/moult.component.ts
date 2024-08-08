import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Moult } from '../../../interfaces/attributes/moult';
import { MoultService } from '../../../services/attributes/moult.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-moult',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './moult.component.html',
  styleUrl: './moult.component.css'
})
export class MoultComponent implements OnInit {
  moults: Moult[] = [];
  
  constructor(private moultService: MoultService, private router: Router) {}

  ngOnInit(): void {
    this.fetchMoults();
  }

  fetchMoults(): void {
    this.moultService.getAllMoults().subscribe({
      next: (data) => {
        this.moults = data;
      },
      error: (err) => {
        console.error('Error fetching moults', err);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}