import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  imageSrc = 'assets/images/homePage.jpg';
  isRotated = false;
  isExtended = false;

  constructor() {}

  ngOnInit(): void {
    // No dark mode logic needed here anymore
  }

  rotateImage() {
    const cardContainer = document.querySelector('.card-container');
    if (cardContainer) {
      cardContainer.classList.toggle('flip');
    }
  }
  
  toggleButtonGroup() {
    this.isExtended = !this.isExtended; 
  }
  
}