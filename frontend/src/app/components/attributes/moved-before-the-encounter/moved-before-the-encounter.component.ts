import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MovedBeforeTheEncounter } from '../../../interfaces/attributes/moved-before-the-encounter';
import { MovedBeforeTheEncounterService } from '../../../services/attributes/moved-before-the-encounter.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-moved-before-the-encounter',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './moved-before-the-encounter.component.html',
  styleUrl: './moved-before-the-encounter.component.css'
})
export class MovedBeforeTheEncounterComponent implements OnInit {
  movedBeforeTheEncounterList: MovedBeforeTheEncounter[] = [];

  constructor(
    private movedBeforeTheEncounterService: MovedBeforeTheEncounterService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchMovedBeforeTheEncounter();
  }

  fetchMovedBeforeTheEncounter(): void {
    this.movedBeforeTheEncounterService.getAllMovedBeforeTheEncounter().subscribe({
      next: (data) => {
        this.movedBeforeTheEncounterList = data;
      },
      error: (err) => {
        console.error('Error fetching moved before the encounter', err);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}