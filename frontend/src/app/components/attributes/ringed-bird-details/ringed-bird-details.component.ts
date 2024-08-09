import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { ActivatedRoute, Router } from '@angular/router';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ringed-bird-details',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ringed-bird-details.component.html',
  styleUrl: './ringed-bird-details.component.css',
})
export class RingedBirdDetailComponent implements OnInit {
  ringedBird: RingedBird | undefined;
  editMode = false;

  constructor(
    private route: ActivatedRoute,
    private ringedBirdService: RingedBirdService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getRingedBird();
  }

  getRingedBird(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.ringedBirdService
      .getRingedBirdById(id)
      .subscribe((bird) => (this.ringedBird = bird));
  }
  toggleEditForm(): void {
    this.editMode = !this.editMode;
  }

  onSubmit(): void {
    if (this.ringedBird) {
      this.ringedBirdService
        .updateRingedBird(this.ringedBird.id, this.ringedBird)
        .subscribe({
          next: (updatedBird) => {
            this.ringedBird = updatedBird;
            this.editMode = false; 
            alert('Ringed Bird updated successfully.');
          },
          error: (error) => {
            console.error('Error updating Ringed Bird:', error);
          },
        });
    }
  }
  goBack(): void {
    this.router.navigate(['/ringedBird']);
  }
}
