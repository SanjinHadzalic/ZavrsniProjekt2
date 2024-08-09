import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RingCodeService } from '../../../services/attributes/ring-code.service';
import { Router } from '@angular/router';
import { RingCode } from '../../../interfaces/attributes/ring-code';
import { JwtDecoderService } from '../../../services/jwt-decoder.service';

@Component({
  selector: 'app-ring-code-add',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ring-code-add.component.html',
  styleUrl: './ring-code-add.component.css'
})
export class AddRingCodeComponent {
  username: string = '';
  code: string = '';
  range: number = 0;
  starter: string = '';
  decodedToken: any
  accessToken: any

  rangeOptions: number[] = [1, 5, 10, 50, 100];
  codeOptions: string[] = ["AA", "BJ", "BA", "CA", "DA", "DS", "EA", "HA", "HS", "JA", "KA", "LA", "LS", "MA", "MS", "PA", "PS", "SA", "TA", "UA"];

  constructor(
    private ringCodeService: RingCodeService,
    private router: Router,
    private decoderService: JwtDecoderService
  ) {}

  onSubmit(): void {
    this.accessToken = localStorage.getItem('accessToken')

    this.decodedToken = this.decoderService.decodeToken(this.accessToken)
    this.ringCodeService.generateNewRingCode(this.decodedToken.sub, this.code, this.range, this.starter)
      .subscribe({
        next: (data: RingCode[]) => {
          console.log('Ring Code generated successfully:', data);
          this.router.navigate(['/ringCode']);
        },
        error: (error) => {
          console.error('Error generating Ring Code:', error);
        }
      });
  }

  navigateBack(): void {
    this.router.navigate(['/ringCode']);
  }
}