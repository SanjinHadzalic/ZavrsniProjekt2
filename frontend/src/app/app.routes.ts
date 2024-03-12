import { Routes } from '@angular/router';
import { BirdListComponent } from './components/bird-list/bird-list.component';
import { HomeComponent } from './components/home/home.component';
import { PlaceListComponent } from './components/place-list/place-list.component';

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
        path: 'place/all',
        component: PlaceListComponent
    }
];
