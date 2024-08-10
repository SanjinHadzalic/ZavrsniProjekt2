import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PlaceService } from '../../../services/attributes/place.service';
import { Place } from '../../../interfaces/attributes/place';

@Component({
  selector: 'app-ringed-bird-add-existing',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ringed-bird-add-existing.component.html',
  styleUrl: './ringed-bird-add-existing.component.css',
})
export class RingedBirdAddExistingComponent {
  ringCode: string = '';
  existingRingedBird: RingedBird | null = null;
  newRingedBird: RingedBird = {} as RingedBird;
  errorMessage: string = '';
  places: Place[] = [];

  constructor(
    private ringedBirdService: RingedBirdService,
    private router: Router,
    private placeService: PlaceService
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

        // Fetch the list of places
        this.placeService.getPlaceList().subscribe((places) => {
          this.places = places; // Assign the fetched places directly
        });
      },
      (error) => {
        this.errorMessage = 'Error fetching the Ringed Bird.';
        console.error(error);
      }
    );
  }

  saveNewRingedBird(): void {
    if (this.newRingedBird) {
      this.ringedBirdService
        .createNewRingedBirdFromExisting(this.ringCode, this.newRingedBird)
        .subscribe(
          () => {
            this.router.navigate(['/ringedBird']);
          },
          (error) => {
            console.error(error);
          }
        );
    }
  }
}
