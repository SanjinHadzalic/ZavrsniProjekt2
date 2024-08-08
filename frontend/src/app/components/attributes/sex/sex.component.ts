import { Component, OnInit } from '@angular/core';
import { SexService } from '../../../services/attributes/sex.service';
import { Router } from '@angular/router';
import { Sex } from '../../../interfaces/attributes/sex';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sex',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sex.component.html',
  styleUrl: './sex.component.css'
})
export class SexComponent implements OnInit {
  sexes: Sex[] = [];

  constructor(private sexService: SexService, private router: Router) {}

  ngOnInit(): void {
      this.fetchSexes();
  }

  fetchSexes(): void {
      this.sexService.getAllSexes().subscribe({
          next: (data) => {
              this.sexes = data;
          },
          error: (err) => {
              console.error('Error fetching sexes', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}