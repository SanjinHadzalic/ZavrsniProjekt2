import { Component, OnInit } from '@angular/core';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import L from 'leaflet';
import { Place } from '../../../interfaces/attributes/place';

@Component({
  selector: 'app-ringed-bird-search',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ringed-bird-search.component.html',
  styleUrl: './ringed-bird-search.component.css'
})
export class RingedBirdSearchComponent implements OnInit{
  ringCode: string = '';
  ringedBirds: RingedBird[] = [];
  errorMessage: string = '';
  private map!: L.Map;
  private markers!: L.LayerGroup;

  constructor(private ringedBirdService: RingedBirdService) {}

  ngOnInit() {
    this.initMap();
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: [0, 0], // Default center
      zoom: 2, // Default zoom level
    });

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
    }).addTo(this.map);

    this.markers = L.layerGroup().addTo(this.map);
  }

  searchRingedBirds() {
    this.ringedBirdService.getAllRingedBirdsByCode(this.ringCode).subscribe(
      (data) => {
        this.ringedBirds = data;
        this.errorMessage = '';
        this.updateMap();
      },
      (error) => {
        this.errorMessage = 'Error fetching RingedBirds or no RingedBirds found.';
        console.error(error);
      }
    );
  }

  private updateMap(): void {
    this.markers.clearLayers(); // Clear previous markers

    this.ringedBirds.forEach((bird) => {
      const place = bird.placeCode;
      if (place && place.latitude && place.longitude) {
        const marker = L.marker([place.latitude, place.longitude]);
        marker.bindPopup(this.createPopupContent(place));
        marker.addTo(this.markers);
      }
    });

    if (this.ringedBirds.length > 0) {
      const firstBird = this.ringedBirds[0];
      const place = firstBird.placeCode;
      if (place && place.latitude && place.longitude) {
        this.map.setView([place.latitude, place.longitude], 6); // Focus on the first result
      }
    }
  }

  private createPopupContent(place: Place): string {
    return `
      <div><strong>Location Name:</strong> ${place.name}</div>
      <div><strong>Latitude:</strong> ${place.latitude}</div>
      <div><strong>Longitude:</strong> ${place.longitude}</div>
      <div><strong>Precision:</strong> ${place.precision?.code}</div>
    `;
  }}
