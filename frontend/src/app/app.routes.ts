import { Routes } from '@angular/router';
import { BirdListComponent } from './components/bird-list/bird-list.component';
import { HomeComponent } from './components/home/home.component';
import { PlaceListComponent } from './components/place-list/place-list.component';
import { PlaceDetailsComponent } from './components/place-details/place-details.component';

export const routes: Routes = [
    {
        path: 'birds',
        component: BirdListComponent
    },
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'place',
        component: PlaceListComponent
    },
    {
        path: "place/:id",
        component: PlaceDetailsComponent
    }
];
