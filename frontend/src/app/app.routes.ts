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
import { AccuracyOfDateComponent } from './components/attributes/accuracy-of-date/accuracy-of-date.component';
import { AccuracyOfPullusAgeComponent } from './components/attributes/accuracy-of-pullus-age/accuracy-of-pullus-age.component';
import { AgeComponent } from './components/attributes/age/age.component';
import { AlulaComponent } from './components/attributes/alula/alula.component';
import { BillMethodComponent } from './components/attributes/bill-method/bill-method.component';
import { BroodPatchComponent } from './components/attributes/brood-patch/brood-patch.component';
import { BroodSizeComponent } from './components/attributes/brood-size/brood-size.component';
import { CarpalCovertComponent } from './components/attributes/carpal-covert/carpal-covert.component';
import { CatchingLuresComponent } from './components/attributes/catching-lures/catching-lures.component';
import { CatchingMethodsComponent } from './components/attributes/catching-methods/catching-methods.component';
import { CircumstancesPresumedComponent } from './components/attributes/circumstances-presumed/circumstances-presumed.component';
import { CircumstancesComponent } from './components/attributes/circumstances/circumstances.component';
import { EuringCodeIdentifierComponent } from './components/attributes/euring-code-identifier/euring-code-identifier.component';
import { MetalRingInformationComponent } from './components/attributes/metal-ring-information/metal-ring-information.component';
import { FatScoreComponent } from './components/attributes/fat-score/fat-score.component';
import { ManipulatedComponent } from './components/attributes/manipulated/manipulated.component';

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
    path: 'accuracyOfDate',
    component: AccuracyOfDateComponent,
    canActivate: [authGuard]
  },
  {
    path: 'accuracyOfPullusAge',
    component: AccuracyOfPullusAgeComponent,
    canActivate: [authGuard]
  },
  {
    path: 'age',
    component: AgeComponent,
    canActivate: [authGuard]
  },
  {
    path: 'alula',
    component: AlulaComponent,
    canActivate: [authGuard]
  },
  {
    path: 'billMethod',
    component: BillMethodComponent,
    canActivate: [authGuard]
  },
  {
    path: 'broodPatch',
    component: BroodPatchComponent,
    canActivate: [authGuard]
  },
  {
    path: 'broodSize',
    component: BroodSizeComponent,
    canActivate: [authGuard]
  },
  {
    path: 'carpalCovert',
    component: CarpalCovertComponent,
    canActivate: [authGuard]
  },
  {
    path: 'catchingLures',
    component: CatchingLuresComponent,
    canActivate: [authGuard]
  },
  {
    path: 'catchingMethods',
    component: CatchingMethodsComponent,
    canActivate: [authGuard]
  },
  {
    path: 'circumstancesPresumed',
    component: CircumstancesPresumedComponent,
    canActivate: [authGuard]
  },
  {
    path: 'circumstances',
    component: CircumstancesComponent,
    canActivate: [authGuard]
  },
  {
    path: 'euring_code_identifier',
    component: EuringCodeIdentifierComponent,
    canActivate: [authGuard]
  },
  {
    path: 'fatScore',
    component: FatScoreComponent,
    canActivate: [authGuard]
  },
  {
    path: 'manipulated',
    component: ManipulatedComponent,
    canActivate: [authGuard]
  },
  {
    path: 'metalRingInformation',
    component: MetalRingInformationComponent,
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
