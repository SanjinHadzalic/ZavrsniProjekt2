import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  imageSrc = 'assets/images/homePage.jpg'
  isRotated = false;
  isExtended = false;

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
