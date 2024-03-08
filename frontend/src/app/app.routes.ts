import { Routes } from '@angular/router';
import { BirdListComponent } from './components/bird-list/bird-list.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    {
        path: 'birds',
        component: BirdListComponent
    },
    {
        path: '',
        component: HomeComponent
    }
];
