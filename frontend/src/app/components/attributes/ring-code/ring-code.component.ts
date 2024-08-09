import { CommonModule } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { RingCode } from '../../../interfaces/attributes/ring-code';
import { RingCodeService } from '../../../services/attributes/ring-code.service';
import { Router } from '@angular/router';
import { JwtDecoderService } from '../../../services/jwt-decoder.service';

@Component({
  selector: 'app-ring-code',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ring-code.component.html',
  styleUrl: './ring-code.component.css'
})
export class RingCodeComponent implements OnInit {
  ringCodes: RingCode[] = [];
  decodedToken: any;
  accessToken: any

  constructor(
    private ringCodeService: RingCodeService,
    private router: Router,
    private jwtDecoderService: JwtDecoderService
  ) {}

  ngOnInit(): void {
    this.loadRingCodes();
  }

  loadRingCodes(): void {
    this.accessToken = localStorage.getItem('accessToken')

    this.decodedToken = this.jwtDecoderService.decodeToken(this.accessToken);

    console.log('123',this.decodedToken.sub)

    if(this.decodedToken.sub === "admin") {
      this.ringCodeService.getAllRingCodes().subscribe((data) => {
        this.ringCodes = data;
      });
    } else {
      this.ringCodeService.getRingCodesByUsernameAndEmail(this.decodedToken.sub, this.decodedToken.email).subscribe((data) => {
        this.ringCodes = data;
      });
    }
  }

  deleteRingCode(id: number): void {
    this.ringCodeService.deleteRingCodeById(id).subscribe(() => {
      this.loadRingCodes(); 
    });
  }

  navigateBack(): void {
    this.router.navigate(['/']);
  }

  addNewRingCodes(){
    this.router.navigate(['/ringCodeAdd']);
  }
}