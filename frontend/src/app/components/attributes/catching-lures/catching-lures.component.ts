import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CatchingLures } from '../../../interfaces/attributes/catching-lures';
import { CatchingLuresService } from '../../../services/attributes/catching-lures.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-catching-lures',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './catching-lures.component.html',
  styleUrl: './catching-lures.component.css'
})
export class CatchingLuresComponent implements OnInit {
  catchingLures: CatchingLures[] = [];

  constructor(private catchingLuresService: CatchingLuresService, private router: Router) {}

  ngOnInit(): void {
    this.loadCatchingLures();
  }

  loadCatchingLures(): void {
    this.catchingLuresService.getAllCatchingLures().subscribe(
      (data) => {
        this.catchingLures = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes']); // Navigate back to the attributes page
  }
}