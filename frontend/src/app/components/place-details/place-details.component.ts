import { Component, OnInit } from '@angular/core';
import { Place } from '../../classes/place.model';
import { PlaceService } from '../../services/place.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

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
  }

   return() {
    this.router.navigate(["/place"])
  }
}
