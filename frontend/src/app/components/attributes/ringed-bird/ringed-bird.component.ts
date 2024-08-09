import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-ringed-bird',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './ringed-bird.component.html',
  styleUrl: './ringed-bird.component.css'
})
export class RingedBirdComponent implements OnInit {
  ringedBirds: RingedBird[] = [];

  constructor(private ringedBirdService: RingedBirdService, private router: Router) {}

  ngOnInit(): void {
    this.loadRingedBirds();
  }

  loadRingedBirds(): void {
    this.ringedBirdService.getAllRingedBirds().subscribe(data => {
      this.ringedBirds = data;
    });
  }

  onDelete(id: number): void {
    this.ringedBirdService.deleteRingedBird(id).subscribe(() => {
      this.loadRingedBirds();
    });
  }
  goToDetails(id: number): void {
    this.router.navigate(['/ringedBird', id]);
  }
  return(): void {
    this.router.navigate(['/']);
  }
}