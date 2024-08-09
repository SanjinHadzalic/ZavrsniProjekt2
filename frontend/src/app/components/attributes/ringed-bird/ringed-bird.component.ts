import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RingedBird } from '../../../interfaces/attributes/ringed-bird';
import { RingedBirdService } from '../../../services/attributes/ringed-bird.service';
import { Router, RouterLink } from '@angular/router';
import { JwtDecoderService } from '../../../services/jwt-decoder.service';
import { NotificationService } from '../../../services/notification.service';
import { BirdService } from '../../../services/bird.service';
import { Bird } from '../../../classes/bird.model';
import { RingCodeService } from '../../../services/attributes/ring-code.service';
import { RingCode } from '../../../interfaces/attributes/ring-code';
import { AgeService } from '../../../services/attributes/age.service';
import { Age } from '../../../interfaces/attributes/age';
import { RingingScheme } from '../../../interfaces/attributes/ringing-scheme';
import { RingingSchemeService } from '../../../services/attributes/ringing-scheme.service';
import { Sex } from '../../../interfaces/attributes/sex';
import { SexService } from '../../../services/attributes/sex.service';
import { EURINGCodeIdentifierService } from '../../../services/attributes/euring-code-identifier.service';
import { EuringCodeIdentifier } from '../../../interfaces/attributes/euring-code-identifier';
import { StatusService } from '../../../services/attributes/status.service';
import { Status } from '../../../interfaces/attributes/status';
import { PlaceService } from '../../../services/attributes/place.service';
import { Place } from '../../../interfaces/attributes/place';
import { MetalRingInformation } from '../../../interfaces/attributes/metal-ring-information';
import { MetalRingInformationService } from '../../../services/attributes/metal-ring-information.service';
import { PrimaryIdentificationMethodService } from '../../../services/attributes/primary-identification-method.service';
import { PrimaryIdentificationMethod } from '../../../interfaces/attributes/primary-identification-method';
import { CatchingLuresService } from '../../../services/attributes/catching-lures.service';
import { CatchingLures } from '../../../interfaces/attributes/catching-lures';
import { BroodSizeService } from '../../../services/attributes/brood-size.service';
import { BroodSize } from '../../../interfaces/attributes/brood-size';
import { CatchingMethods } from '../../../interfaces/attributes/catching-methods';
import { CatchingMethodsService } from '../../../services/attributes/catching-methods.service';

@Component({
  selector: 'app-ringed-bird',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './ringed-bird.component.html',
  styleUrl: './ringed-bird.component.css',
})
export class RingedBirdComponent implements OnInit {
  ringedBirds: RingedBird[] = [];
  token: any;
  accessToken: any;
  showAddForm: boolean = false; 
  newRingedBird: RingedBird = {} as RingedBird;
  species: Bird[] = []
  ringCodes: RingCode[] = []
  age: Age[] = []
  ringingSchemes: RingingScheme[] = []
  sex: Sex[] = []
  eurings: EuringCodeIdentifier[] =[]
  status: Status[] = []
  places: Place[] =[]
  metalRingInfo: MetalRingInformation[] = []
  primaryIdentification: PrimaryIdentificationMethod[] = []
  catchingLure: CatchingLures[] = []
  broodSize: BroodSize[] = []
  catchingMethod: CatchingMethods[] = []

  constructor(
    private ringedBirdService: RingedBirdService,
    private router: Router,
    private decodeService: JwtDecoderService,
    private notificationService: NotificationService,
    private birdService: BirdService,
    private ringCodeService: RingCodeService,
    private ageService: AgeService,
    private ringingSchemeService: RingingSchemeService,
    private sexService: SexService,
    private euringService: EURINGCodeIdentifierService,
    private statusService: StatusService,
    private placeService: PlaceService,
    private metalRingInfoService: MetalRingInformationService,
    private primaryIdentificationService: PrimaryIdentificationMethodService,
    private catchingLureService: CatchingLuresService,
    private broodSizeService: BroodSizeService,
    private catchingMethodService: CatchingMethodsService
  ) {}

  ngOnInit(): void {
    this.accessToken = localStorage.getItem('accessToken');

    this.token = this.decodeService.decodeToken(this.accessToken);
    if (this.accessToken) {
      if (this.token.sub === 'admin') {
        this.loadRingedBirds();
      } else {
        this.loadRingedBirdsByUser(this.token.sub);
      }
    }

    this.birdService.getBirdList().subscribe((data) => {
      this.species = data
    })

    this.ringCodeService.getAllAvailableRingCodes().subscribe((data) => {
      this.ringCodes = data
    })

    this.ageService.getAllAges().subscribe((data) => {
      this.age = data
    })

    this.ringingSchemeService.getAllRingingSchemes().subscribe((data) => {
      this.ringingSchemes = data
    })

    this.sexService.getAllSexes().subscribe((data) => {
      this.sex = data
    })

    this.euringService.getAllEURINGCodeIdentifier().subscribe((data) => {
      this.eurings = data
    })

    this.statusService.getAllStatuses().subscribe((data) => {
      this.status = data
    })

    this.placeService.getPlaceList().subscribe((data) => {
      this.places = data
    })

    this.metalRingInfoService.getAllMetalRingInformations().subscribe((data) => {
      this.metalRingInfo = data
    })

    this.primaryIdentificationService.getAllPrimaryIdentificationMethods().subscribe((data) => {
      this.primaryIdentification = data
    })

    this.catchingLureService.getAllCatchingLures().subscribe((data) => {
      this.catchingLure = data
    })

    this.broodSizeService.getAllBroodSizes().subscribe((data) => {
      this.broodSize = data
    })

    this.catchingMethodService.getAllCatchingMethods().subscribe((data) => {
      this.catchingMethod = data
    })

  }

  loadRingedBirds(): void {
    this.ringedBirdService.getAllRingedBirds().subscribe((data) => {
      this.ringedBirds = data;
    });
  }

  loadRingedBirdsByUser(username: string): void {
    this.accessToken = localStorage.getItem('accessToken');

    this.token = this.decodeService.decodeToken(this.accessToken);

    this.ringedBirdService
      .getAllRingedBirdsByUser(username)
      .subscribe((data) => {
        this.ringedBirds = data;
      });
  }

  onDelete(id: number): void {
    this.accessToken = localStorage.getItem('accessToken');
    this.token = this.decodeService.decodeToken(this.accessToken);

    const confirmDelete = () => {
      this.ringedBirdService.deleteRingedBird(id).subscribe(() => {
        if (this.token.sub === 'admin') {
          this.loadRingedBirds();
        } else {
          this.loadRingedBirdsByUser(this.token.sub);
        }
      });
    };

    this.notificationService.confirmationDialog(
      'Confirm Deletion',
      'Are you sure you want to delete this ringed bird?',
      confirmDelete
    );
  }
  goToDetails(id: number): void {
    this.router.navigate(['/ringedBird', id]);
  }

  toggleAddForm(): void {
    this.showAddForm = !this.showAddForm;
  }

  addRingedBird(): void {
    console.log('prvi sam')
    this.ringedBirdService.createRingedBird(this.newRingedBird).subscribe((bird) => {
      this.ringedBirds.push(bird);
      this.showAddForm = false;
      this.newRingedBird = {} as RingedBird; 
      this.notificationService.successNotification('Success', 'Ringed bird added successfully');
    }, error => {
      this.notificationService.errorNotification('Error', 'Failed to add ringed bird');
    });
  }

  return(): void {
    this.router.navigate(['/']);
  }
}
