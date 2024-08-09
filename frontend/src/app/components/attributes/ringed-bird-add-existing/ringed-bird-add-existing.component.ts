import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ringed-bird-add-existing',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ringed-bird-add-existing.component.html',
  styleUrl: './ringed-bird-add-existing.component.css'
})
export class RingedBirdAddExistingComponent {
  ringCode: string = '';
  existingRingedBird: RingedBird | null = null;
  newRingedBird: RingedBird = {} as RingedBird;
  errorMessage: string = '';

  constructor(
    private ringedBirdService: RingedBirdService,
    private router: Router
  ) {}

  fetchExistingRingedBird(): void {
    this.errorMessage = ''; 
  
    if (!this.ringCode) {
      this.errorMessage = 'Ring Code cannot be empty.';
      return;
    }
  
    this.ringedBirdService.getRingedBirdByCode(this.ringCode).subscribe(
      (data: RingedBird) => { 
        this.existingRingedBird = data; 
        this.newRingedBird = { ...this.existingRingedBird }; 
      },
      (error) => {
        this.errorMessage = 'Error fetching the RingedBird.';
        console.error(error);
      }
    );
  }

  saveNewRingedBird(): void {
    if (this.newRingedBird) {
      this.ringedBirdService.createNewRingedBirdFromExisting(this.ringCode, this.newRingedBird).subscribe(
        () => {
          // alert('Ringed Bird added successfully!');
          this.router.navigate(['/ringedBird']); 
        },
        (error) => {
          // alert('Error adding Ringed Bird.');
          console.error(error);
        }
      );
    }
  }
}
