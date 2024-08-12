import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Place } from '../../../interfaces/attributes/place';
import { PlaceService } from '../../../services/attributes/place.service';
import { NotificationService } from '../../../services/notification.service';
import { TranslateModule } from '@ngx-translate/core';

@Component({
  selector: 'app-place-list',
  standalone: true,
  imports: [CommonModule, TranslateModule],
  templateUrl: './place-list.component.html',
  styleUrl: './place-list.component.css',
  providers: [PlaceService]
})
export class PlaceListComponent implements OnInit{
  places!: Place[];
  notificationService = inject(NotificationService)
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

  addNewPlace() {
    this.router.navigate(['/placeAdd'])
  }

  deletePlace(id: number) {
    this.notificationService.confirmationDialog(
      'Are you sure?',
      'Do you really want to delete this place? This action cannot be undone!',
      () => {
        this.placeService.deletePlace(id).subscribe(
          () => {
            this.notificationService.successNotification(
              'Deleted!',
              'Place has been deleted.'
            );
            this.getPlaces(); 
          },
          (error) => {
            this.notificationService.errorNotification(
              'Error!',
              'There was a problem deleting the place.'
            );
          }
        );
      }
    );
  }
}

