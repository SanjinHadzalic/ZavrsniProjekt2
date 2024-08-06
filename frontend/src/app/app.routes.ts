import { Routes } from '@angular/router';
import { BirdListComponent } from './components/bird-list/bird-list.component';
import { HomeComponent } from './components/home/home.component';
import { PlaceListComponent } from './components/place-list/place-list.component';
import { PlaceDetailsComponent } from './components/place-details/place-details.component';
import { BirdDetailsComponent } from './components/bird-details/bird-details.component';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'birds',
        component: BirdListComponent
    },
    {
        path: 'birds/:id',
        component: BirdDetailsComponent
    },
    {
        path: 'place',
        component: PlaceListComponent
    },
    {
        path: "place/:id",
        component: PlaceDetailsComponent
    },
    {
        path: 'login',
        component: LoginComponent
    }
];
