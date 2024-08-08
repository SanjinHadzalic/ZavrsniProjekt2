import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { OtherMarksInformation } from '../../../interfaces/attributes/other-marks-information';
import { OtherMarksInformationService } from '../../../services/attributes/other-marks-information.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-other-marks-information',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './other-marks-information.component.html',
  styleUrl: './other-marks-information.component.css'
})
export class OtherMarksInformationComponent implements OnInit {
  otherMarksInformationList: OtherMarksInformation[] = [];

  constructor(
    private otherMarksInformationService: OtherMarksInformationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.fetchOtherMarksInformation();
  }

  fetchOtherMarksInformation(): void {
    this.otherMarksInformationService.getAllOtherMarksInformation().subscribe({
      next: (data) => {
        this.otherMarksInformationList = data;
      },
      error: (err) => {
        console.error('Error fetching other marks information', err);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/attributes']);
  }
}