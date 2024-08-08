import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { latLng, LeafletMouseEvent, tileLayer } from 'leaflet';
import { PlaceService } from '../../../services/attributes/place.service';
import { Router } from '@angular/router';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { AccuracyOfCoordinates } from '../../../interfaces/attributes/accuracy-of-coordinates';
import { AccuracyOfCoordinatesService } from '../../../services/attributes/accuracy-of-coordinates.service';

@Component({
  selector: 'app-place-add',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, LeafletModule],
  templateUrl: './place-add.component.html',
  styleUrl: './place-add.component.css'
})
export class PlaceAddComponent implements OnInit {
  placeForm!: FormGroup;
  mapOptions: any;
  mapCenter = latLng([51.505, -0.09]); // Default center
  mapZoom = 5; // Default zoom
  latitude: number | undefined;
  longitude: number | undefined;
  precisions: AccuracyOfCoordinates[] = [];

  constructor(
    private fb: FormBuilder,
    private placeService: PlaceService,
    private accuracyService: AccuracyOfCoordinatesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initForm();
    this.loadPrecisions();
    
    this.mapOptions = {
      layers: [
        tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
          maxZoom: 18,
          attribution: '© OpenStreetMap'
        })
      ],
      zoom: this.mapZoom,
      center: this.mapCenter
    };
  }

  loadPrecisions() {
    this.accuracyService.getAllAccuracyOfCoordinates().subscribe((data: AccuracyOfCoordinates[]) => {
      console.log(data)
      this.precisions = data;
    });
  }

  initForm(): void {
    this.placeForm = this.fb.group({
      name: ['', Validators.required],
      country: ['', Validators.required],
      regionCode: ['', Validators.required],
      latitude: ['', Validators.required],
      longitude: ['', Validators.required],
      precision: [null, Validators.required], 
      notes: ['']
    });
  }

  onMapClick(event: LeafletMouseEvent): void {
    this.latitude = event.latlng.lat;
    this.longitude = event.latlng.lng;
    this.placeForm.patchValue({
      latitude: this.latitude,
      longitude: this.longitude
    });
  }

  onSubmit(): void {
    if (1==1) {
      console.log("unutra")
      this.placeService.createPlace(this.placeForm.value).subscribe(() => {
        this.router.navigate(['/place']);
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/place']);
  }
}