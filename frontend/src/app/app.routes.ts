import { Routes } from '@angular/router';
import { BirdListComponent } from './components/bird-list/bird-list.component';
import { HomeComponent } from './components/home/home.component';
import { PlaceListComponent } from './components/attributes/place-list/place-list.component';
import { PlaceDetailsComponent } from './components/attributes/place-details/place-details.component';
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
import { MoultComponent } from './components/attributes/moult/moult.component';
import { MovedBeforeTheEncounterComponent } from './components/attributes/moved-before-the-encounter/moved-before-the-encounter.component';
import { OtherMarksInformationComponent } from './components/attributes/other-marks-information/other-marks-information.component';
import { PectoralMuscleScoreComponent } from './components/attributes/pectoral-muscle-score/pectoral-muscle-score.component';
import { PlumageCodeComponent } from './components/attributes/plumage-code/plumage-code.component';
import { PrimaryIdentificationMethodComponent } from './components/attributes/primary-identification-method/primary-identification-method.component';
import { PrimaryMoultComponent } from './components/attributes/primary-moult/primary-moult.component';
import { RingingSchemeComponent } from './components/attributes/ringing-scheme/ringing-scheme.component';
import { SexComponent } from './components/attributes/sex/sex.component';
import { SexingMethodComponent } from './components/attributes/sexing-method/sexing-method.component';
import { StateOfWingPointComponent } from './components/attributes/state-of-wing-point/state-of-wing-point.component';
import { StatusComponent } from './components/attributes/status/status.component';
import { TarsusMethodComponent } from './components/attributes/tarsus-method/tarsus-method.component';
import { VerificationOfTheMetalRingComponent } from './components/attributes/verification-of-the-metal-ring/verification-of-the-metal-ring.component';
import { PlaceAddComponent } from './components/attributes/place-add/place-add.component';
import { RingCodeComponent } from './components/attributes/ring-code/ring-code.component';
import { AddRingCodeComponent } from './components/attributes/ring-code-add/ring-code-add.component';
import { RingedBirdComponent } from './components/attributes/ringed-bird/ringed-bird.component';
import { RingedBirdDetailComponent } from './components/attributes/ringed-bird-details/ringed-bird-details.component';
import { PullusAgeComponent } from './components/attributes/pullus-age/pullus-age.component';
import { ConditionComponent } from './components/attributes/condition/condition.component';
import { RingedBirdAddExistingComponent } from './components/attributes/ringed-bird-add-existing/ringed-bird-add-existing.component';
import { RingedBirdSearchComponent } from './components/attributes/ringed-bird-search/ringed-bird-search.component';
import { StatisticsComponent } from './components/attributes/statistics/statistics.component';
import { GenerateComponent } from './components/attributes/generate/generate.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { adminAuthGuard } from './guards/admin-auth.guard';
import { UploadExcelComponent } from './components/attributes/upload/upload.component';

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
    path: 'placeAdd',
    component: PlaceAddComponent,
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
    canActivate: [authGuard],
  },
  {
    path: 'accuracyOfDate',
    component: AccuracyOfDateComponent,
    canActivate: [authGuard],
  },
  {
    path: 'accuracyOfPullusAge',
    component: AccuracyOfPullusAgeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'age',
    component: AgeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'alula',
    component: AlulaComponent,
    canActivate: [authGuard],
  },
  {
    path: 'billMethod',
    component: BillMethodComponent,
    canActivate: [authGuard],
  },
  {
    path: 'broodPatch',
    component: BroodPatchComponent,
    canActivate: [authGuard],
  },
  {
    path: 'broodSize',
    component: BroodSizeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'carpalCovert',
    component: CarpalCovertComponent,
    canActivate: [authGuard],
  },
  {
    path: 'catchingLures',
    component: CatchingLuresComponent,
    canActivate: [authGuard],
  },
  {
    path: 'catchingMethods',
    component: CatchingMethodsComponent,
    canActivate: [authGuard],
  },
  {
    path: 'circumstancesPresumed',
    component: CircumstancesPresumedComponent,
    canActivate: [authGuard],
  },
  {
    path: 'circumstances',
    component: CircumstancesComponent,
    canActivate: [authGuard],
  },
  {
    path: 'euring_code_identifier',
    component: EuringCodeIdentifierComponent,
    canActivate: [adminAuthGuard],
  },
  {
    path: 'fatScore',
    component: FatScoreComponent,
    canActivate: [authGuard],
  },
  {
    path: 'manipulated',
    component: ManipulatedComponent,
    canActivate: [authGuard],
  },
  {
    path: 'metalRingInformation',
    component: MetalRingInformationComponent,
    canActivate: [authGuard],
  },
  {
    path: 'moult',
    component: MoultComponent,
    canActivate: [authGuard],
  },
  {
    path: 'movedBeforeTheEncounter',
    component: MovedBeforeTheEncounterComponent,
    canActivate: [authGuard],
  },
  {
    path: 'otherMarksInformation',
    component: OtherMarksInformationComponent,
    canActivate: [authGuard],
  },
  {
    path: 'pectoralMuscleScore',
    component: PectoralMuscleScoreComponent,
    canActivate: [authGuard],
  },
  {
    path: 'plumageCode',
    component: PlumageCodeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'primaryIdentificationMethod',
    component: PrimaryIdentificationMethodComponent,
    canActivate: [authGuard],
  },
  {
    path: 'primaryMoult',
    component: PrimaryMoultComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringingScheme',
    component: RingingSchemeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'sex',
    component: SexComponent,
    canActivate: [authGuard],
  },
  {
    path: 'sexingMethod',
    component: SexingMethodComponent,
    canActivate: [authGuard],
  },
  {
    path: 'stateOfWingPoint',
    component: StateOfWingPointComponent,
    canActivate: [authGuard],
  },
  {
    path: 'status',
    component: StatusComponent,
    canActivate: [authGuard],
  },
  {
    path: 'tarsusMethod',
    component: TarsusMethodComponent,
    canActivate: [authGuard],
  },
  {
    path: 'verificationOfTheMetalRing',
    component: VerificationOfTheMetalRingComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringCode',
    component: RingCodeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringCodeAdd',
    component: AddRingCodeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringedBird',
    component: RingedBirdComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringedBirdExisting',
    component: RingedBirdAddExistingComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringedBird/:id',
    component: RingedBirdDetailComponent,
    canActivate: [authGuard],
  },
  {
    path: 'ringedBirdSearch',
    component: RingedBirdSearchComponent,
    canActivate: [authGuard],
  },
  {
    path: 'pullusAge',
    component: PullusAgeComponent,
    canActivate: [authGuard],
  },
  {
    path: 'condition',
    component: ConditionComponent,
    canActivate: [authGuard],
  },
  {
    path: 'statistics',
    component: StatisticsComponent,
    canActivate: [authGuard],
  },
  {
    path: 'generate',
    component: GenerateComponent,
    canActivate: [authGuard],
  },
  {
    path: 'upload',
    component: UploadExcelComponent,
    canActivate: [authGuard],
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
  {
    path: 'forbidden',
    component: ForbiddenComponent,
  },
];
