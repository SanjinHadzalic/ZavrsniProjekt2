import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CircumstancesPresumed } from '../../../interfaces/attributes/circumstances-presumed';
import { CircumstancesPresumedService } from '../../../services/attributes/circumstances-presumed.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-circumstances-presumed',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './circumstances-presumed.component.html',
  styleUrl: './circumstances-presumed.component.css'
})
export class CircumstancesPresumedComponent implements OnInit {
  circumstancesPresumed: CircumstancesPresumed[] = [];

  constructor(private circumstancesPresumedService: CircumstancesPresumedService, private router: Router) {}

  ngOnInit(): void {
    this.loadCircumstancesPresumed();
  }

  loadCircumstancesPresumed(): void {
    this.circumstancesPresumedService.getAllCircumstancesPresumed().subscribe(
      (data) => {
        this.circumstancesPresumed = data;
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