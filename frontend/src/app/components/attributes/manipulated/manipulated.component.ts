import { Component, OnInit } from '@angular/core';
import { Manipulated } from '../../../interfaces/attributes/manipulated';
import { ManipulatedService } from '../../../services/attributes/manipulated.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-manipulated',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './manipulated.component.html',
  styleUrl: './manipulated.component.css'
})
export class ManipulatedComponent implements OnInit {
  manipulatedRecords: Manipulated[] = [];
  
  constructor(private manipulatedService: ManipulatedService, private router: Router) {}

  ngOnInit(): void {
    this.fetchManipulatedRecords();
  }

  fetchManipulatedRecords(): void {
    this.manipulatedService.getAllManipulated().subscribe({
      next: (data) => {
        this.manipulatedRecords = data;
      },
      error: (err) => {
        console.error('Error fetching manipulated records', err);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}