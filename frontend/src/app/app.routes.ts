import { Routes } from '@angular/router';
import { BirdListComponent } from './components/bird-list/bird-list.component';
import { HomeComponent } from './components/home/home.component';
import { PlaceListComponent } from './components/place-list/place-list.component';
import { PlaceDetailsComponent } from './components/place-details/place-details.component';
import { BirdDetailsComponent } from './components/bird-details/bird-details.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { authGuard } from './guards/auth.guard';
import { ProfileComponent } from './components/profile/profile.component';
import { AttributesComponent } from './components/attributes/attributes.component';
import { AccuracyOfCoordinatesComponent } from './components/attributes/accuracy-of-coordinates/accuracy-of-coordinates.component';

export const routes: Routes = [
  {
    path: 'attributes',
    component: AttributesComponent,
    canActivate: [authGuard],
  },
  {
    path: 'birds',
    component: BirdListComponent,
    canActivate: [authGuard],
  },
  {
    path: 'birds/:id',
    component: BirdDetailsComponent,
    canActivate: [authGuard],
  },
  {
    path: 'place',
    component: PlaceListComponent,
    canActivate: [authGuard],
  },
  {
    path: 'place/:id',
    component: PlaceDetailsComponent,
    canActivate: [authGuard],
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [authGuard],
  },
  {
    path: 'accuracyOfCoordinates',
    component: AccuracyOfCoordinatesComponent,
    canActivate: [authGuard]
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: '',
    component: HomeComponent,
    canActivate: [authGuard],
  },
//   {
//     path: "**",                          // TODO Add 404 page
//     component: PageNotFoundComponent
//   }
];
