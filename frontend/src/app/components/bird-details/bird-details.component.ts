import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Bird } from '../../classes/bird.model';
import { BirdService } from '../../services/bird.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';

@Component({
  selector: 'app-bird-details',
  standalone: true,
  imports: [CommonModule, TranslateModule],
  templateUrl: './bird-details.component.html',
  styleUrl: './bird-details.component.css'
})
export class BirdDetailsComponent {
  id!: number;
  bird: Bird = new Bird();

  constructor(
    private birdService: BirdService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.birdService.getBirdById(this.route.snapshot.params['id'])
    .subscribe((bird) => {
      this.bird = bird;
    })
  }

  return() {
    this.router.navigate(['/birds']);
  }
}
