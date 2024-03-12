import { Component, OnInit } from '@angular/core';
import { Place } from '../../classes/place.model';
import { PlaceService } from '../../services/place.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import Map from 'ol/Map';
import TileLayer from 'ol/layer/Tile';
import { OSM } from 'ol/source';
import View from 'ol/View';

@Component({
  selector: 'app-place-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './place-details.component.html',
  styleUrl: './place-details.component.css'
})
export class PlaceDetailsComponent implements OnInit{
  id!: number;
  place: Place = new Place();
  map!: Map;

  constructor(private placeService: PlaceService, private route: ActivatedRoute, private router: Router) {}

  private getPlaceById() {
    this.id = this.route.snapshot.params['id'];
    this.placeService.getPlaceById(this.id).subscribe({
      next: (data) => {
        this.place = data;
      },
      error: (e) => {
        console.log(e);
      }
    })
  }

  ngOnInit(): void {
    this.getPlaceById();
    this.map = new Map({
      layers: [
        new TileLayer({
          source: new OSM(),
        }),
      ],
        target: 'map',
        view: new View({
          center: [0, 0],
          zoom: 2, maxZoom: 18
        })
    })
  }

   return() {
    this.router.navigate(["/place"])
  }
}
