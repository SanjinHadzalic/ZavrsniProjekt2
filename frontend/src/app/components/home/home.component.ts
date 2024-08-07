import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  imageSrc = 'assets/images/homePage.jpg'
  isRotated = false;


  rotateImage() {
    const cardContainer = document.querySelector('.card-container');
    if (cardContainer) {
      cardContainer.classList.toggle('flip');
    }
  }
  
}
