import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Circumstances } from '../../../interfaces/attributes/circumstances';
import { CircumstancesService } from '../../../services/attributes/circumstances.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-circumstances',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './circumstances.component.html',
  styleUrl: './circumstances.component.css'
})
export class CircumstancesComponent implements OnInit {
  circumstances: Circumstances[] = [];

  constructor(private circumstancesService: CircumstancesService, private router: Router) {}

  ngOnInit(): void {
    this.loadCircumstances();
  }

  loadCircumstances(): void {
    this.circumstancesService.getAllCircumstances().subscribe(
      (data) => {
        this.circumstances = data;
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