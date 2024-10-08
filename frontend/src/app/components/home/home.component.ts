import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, TranslateModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  imageSrc = 'assets/images/homePage.jpg';
  isRotated = false;
  isExtended = false;
  isImportExportExtended = false; 

  constructor() {}

  ngOnInit(): void {
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

  toggleImportExport() {
    this.isImportExportExtended = !this.isImportExportExtended;
  }
}