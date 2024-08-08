import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Place } from '../../../interfaces/attributes/place';
import { PlaceService } from '../../../services/attributes/place.service';

@Component({
  selector: 'app-place-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './place-list.component.html',
  styleUrl: './place-list.component.css',
  providers: [PlaceService]
})
export class PlaceListComponent implements OnInit{
  places!: Place[];

  constructor(private placeService: PlaceService, private router: Router) {}


  ngOnInit(): void {
    this.getPlaces();
    this.router.navigate(['/place']);
  }

  private getPlaces() {
    this.placeService.getPlaceList().subscribe(data => {
      this.places = data;
    })
  }

  placeDetails(id: number) {
    this.router.navigate(["place", id]);
  }
}

