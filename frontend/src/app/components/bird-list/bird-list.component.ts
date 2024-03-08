import { Component, OnInit } from '@angular/core';
import { Bird } from '../../classes/bird.model';
import { BirdService } from '../../services/bird.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bird-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './bird-list.component.html',
  styleUrl: './bird-list.component.css',
  providers: [BirdService]
})
export class BirdListComponent implements OnInit{
  birds!: Bird[];

  constructor(private birdService: BirdService, private router: Router) {

  }

  ngOnInit(): void {
    this.getBirds();
    this.router.navigate(['/birds']);
  }

  private getBirds() {
    this.birdService.getBirdList().subscribe(data => {
      this.birds = data;
    });
  }
}
