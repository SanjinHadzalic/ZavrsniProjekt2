import { Component, OnInit } from '@angular/core';
import { PlaceService } from '../../services/place.service';
import { Place } from '../../classes/place.model';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

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

