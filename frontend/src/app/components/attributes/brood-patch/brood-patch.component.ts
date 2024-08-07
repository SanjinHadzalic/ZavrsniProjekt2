import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { BroodPatchService } from '../../../services/attributes/brood-patch.service';
import { Router } from '@angular/router';
import { BroodPatch } from '../../../interfaces/attributes/brood-patch';

@Component({
  selector: 'app-brood-patch',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './brood-patch.component.html',
  styleUrl: './brood-patch.component.css'
})
export class BroodPatchComponent implements OnInit {
  broodPatches: BroodPatch[] = [];

  constructor(private broodPatchService: BroodPatchService, private router: Router) {}

  ngOnInit(): void {
    this.loadBroodPatches();
  }

  loadBroodPatches(): void {
    this.broodPatchService.getAllBroodPatches().subscribe(
      (data) => {
        this.broodPatches = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes']); 
  }
}