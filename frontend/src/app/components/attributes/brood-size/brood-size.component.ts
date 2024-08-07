import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { BroodSizeService } from '../../../services/attributes/brood-size.service';
import { Router } from '@angular/router';
import { BroodSize } from '../../../interfaces/attributes/brood-size';

@Component({
  selector: 'app-brood-size',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './brood-size.component.html',
  styleUrl: './brood-size.component.css'
})
export class BroodSizeComponent implements OnInit {
  broodSizes: BroodSize[] = [];

  constructor(private broodSizeService: BroodSizeService, private router: Router) {}

  ngOnInit(): void {
    this.loadBroodSizes();
  }

  loadBroodSizes(): void {
    this.broodSizeService.getAllBroodSizes().subscribe(
      (data) => {
        this.broodSizes = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes']); 
  }
}