import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import Map from 'ol/Map';
import TileLayer from 'ol/layer/Tile';
import { OSM } from 'ol/source';
import View from 'ol/View';
import L from 'leaflet';
import { Place } from '../../../interfaces/attributes/place';
import { PlaceService } from '../../../services/attributes/place.service';

@Component({
  selector: 'app-place-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './place-details.component.html',
  styleUrl: './place-details.component.css',
})
export class PlaceDetailsComponent implements OnInit {
  id!: number;
  place?: Place;

  constructor(
    private placeService: PlaceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.placeService
      .getPlaceById(this.route.snapshot.params['id'])
      .subscribe((place) => {
        this.place = place;
        // console.log(this.place.latitude);
        const map = L.map('map').setView(
          [this.place.latitude, this.place.longitude],
          13
        );

        const marker = L.marker([this.place.latitude, this.place.longitude]);

        const iconRetinaUrl = 'assets/marker-icon-2x.png';
        const iconUrl = 'assets/marker-icon.png';
        const shadowUrl = 'assets/marker-shadow.png';
        const iconDefault = L.icon({
          iconRetinaUrl,
          iconUrl,
          shadowUrl,
          iconSize: [25, 41],
          iconAnchor: [12, 41],
          popupAnchor: [1, -34],
          tooltipAnchor: [16, -28],
          shadowSize: [41, 41],
        });



        L.Marker.prototype.options.icon = iconDefault;
        marker.bindPopup(this.makeCapitalPopup(this.place));
        marker.addTo(map);

        const tileUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
        const attribution =
          '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';

        const tileLayer = L.tileLayer(tileUrl, { attribution });
        tileLayer.addTo(map);
      });
  }

  makeCapitalPopup(data: any):string {
    return `` + 
    `<div>Name: ${ data.name}</div>` + 
    `<div>Latitude: ${ data.latitude}</div>` +
    `<div>Longitude: ${ data.longitude}</div>`
  }

  return() {
    this.router.navigate(['/place']);
  }
}
