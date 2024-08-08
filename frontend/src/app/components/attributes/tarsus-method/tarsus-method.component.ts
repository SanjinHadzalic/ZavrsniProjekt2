import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TarsusMethod } from '../../../interfaces/attributes/tarsus-method';
import { TarsusMethodService } from '../../../services/attributes/tarsus-method.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tarsus-method',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './tarsus-method.component.html',
  styleUrl: './tarsus-method.component.css'
})
export class TarsusMethodComponent implements OnInit {
  tarsusMethods: TarsusMethod[] = [];

  constructor(private tarsusMethodService: TarsusMethodService, private router: Router) {}

  ngOnInit(): void {
      this.fetchTarsusMethods();
  }

  fetchTarsusMethods(): void {
      this.tarsusMethodService.getAllTarsusMethods().subscribe({
          next: (data) => {
              this.tarsusMethods = data;
          },
          error: (err) => {
              console.error('Error fetching tarsus methods', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}