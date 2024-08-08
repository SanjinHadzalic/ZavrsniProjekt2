import { Component, OnInit } from '@angular/core';
import { Status } from '../../../interfaces/attributes/status';
import { StatusService } from '../../../services/attributes/status.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-status',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './status.component.html',
  styleUrl: './status.component.css'
})
export class StatusComponent implements OnInit {
  statuses: Status[] = [];

  constructor(private statusService: StatusService, private router: Router) {}

  ngOnInit(): void {
      this.fetchStatuses();
  }

  fetchStatuses(): void {
      this.statusService.getAllStatuses().subscribe({
          next: (data) => {
              this.statuses = data;
          },
          error: (err) => {
              console.error('Error fetching statuses', err);
          }
      });
  }

  return(): void {
      this.router.navigate(['/attributes']);
  }
}