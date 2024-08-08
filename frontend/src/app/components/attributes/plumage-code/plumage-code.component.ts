import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PlumageCode } from '../../../interfaces/attributes/plumage-code';
import { PlumageCodeService } from '../../../services/attributes/plumage-code.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-plumage-code',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './plumage-code.component.html',
  styleUrl: './plumage-code.component.css'
})
export class PlumageCodeComponent implements OnInit {
  plumageCodes: PlumageCode[] = [];

  constructor(
      private plumageCodeService: PlumageCodeService,
      private router: Router
  ) {}

  ngOnInit(): void {
      this.fetchPlumageCodes();
  }

  fetchPlumageCodes(): void {
      this.plumageCodeService.getAllPlumageCodes().subscribe({
          next: (data) => {
              this.plumageCodes = data;
          },
          error: (err) => {
              console.error('Error fetching plumage codes', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}