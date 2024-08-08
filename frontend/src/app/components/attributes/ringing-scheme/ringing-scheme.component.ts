import { Component, OnInit } from '@angular/core';
import { RingingScheme } from '../../../interfaces/attributes/ringing-scheme';
import { RingingSchemeService } from '../../../services/attributes/ringing-scheme.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ringing-scheme',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ringing-scheme.component.html',
  styleUrl: './ringing-scheme.component.css'
})
export class RingingSchemeComponent implements OnInit {
  ringingSchemes: RingingScheme[] = [];
  newRingingScheme: RingingScheme = {
      id: 0,
      code: '',
      country: '',
      centre: '',
      euring: false,
      current: false,
      dateUpdated: new Date,
      notes: ''
  };

  constructor(
      private ringingSchemeService: RingingSchemeService,
      private router: Router
  ) {}

  ngOnInit(): void {
      this.fetchRingingSchemes();
  }

  fetchRingingSchemes(): void {
      this.ringingSchemeService.getAllRingingSchemes().subscribe({
          next: (data) => {
              this.ringingSchemes = data;
          },
          error: (err) => {
              console.error('Error fetching ringing schemes', err);
          }
      });
  }

  saveRingingScheme(): void {
      this.ringingSchemeService.saveRingingScheme(this.newRingingScheme).subscribe({
          next: (scheme) => {
              this.ringingSchemes.push(scheme);
              this.newRingingScheme = {
                  id: 0,
                  code: '',
                  country: '',
                  centre: '',
                  euring: false,
                  current: false,
                  dateUpdated: new Date,
                  notes: ''
              }; // Reset the form
          },
          error: (err) => {
              console.error('Error saving ringing scheme', err);
          }
      });
  }

  deleteRingingScheme(id: number): void {
      this.ringingSchemeService.deleteRingingScheme(id).subscribe({
          next: () => {
              this.ringingSchemes = this.ringingSchemes.filter(s => s.id !== id);
          },
          error: (err) => {
              console.error('Error deleting ringing scheme', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}