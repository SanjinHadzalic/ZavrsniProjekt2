import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-statistics',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './statistics.component.html',
  styleUrl: './statistics.component.css'
})
export class StatisticsComponent {
  filters = {
    ringCode: '',
    date: '',
    country: '',
    year: '',
    month: '',
    placeCode: '',
    username: '',
    sex: '',
    age: '',
  };
  ringedBirds: RingedBird[] = [];
  errorMessage: string = '';

  constructor(private ringedBirdService: RingedBirdService) {}

  ngOnInit(): void {
    // Fetch all ringed birds on component initialization
    this.fetchRingedBirds(); // Call the fetch method to initialize data
  }

  fetchRingedBirds(): void {
    this.errorMessage = '';

    // Call the service method with the filters
    this.ringedBirdService.searchRingedBirds(this.filters).subscribe(
      (data) => {
        this.ringedBirds = data;
        if (this.ringedBirds.length === 0) {
          this.errorMessage = 'No results found.';
        }
      },
      (error) => {
        this.errorMessage = 'Error fetching ringed birds.';
        console.error(error);
      }
    );
  }
}
