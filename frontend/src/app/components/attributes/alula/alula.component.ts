import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AlulaService } from '../../../services/attributes/alula.service';
import { Router } from '@angular/router';
import { Alula } from '../../../interfaces/attributes/alula';

@Component({
  selector: 'app-alula',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './alula.component.html',
  styleUrl: './alula.component.css'
})
export class AlulaComponent implements OnInit {
  alulas: Alula[] = [];

  constructor(private alulaService: AlulaService, private router: Router) {}

  ngOnInit(): void {
    this.loadAlulas();
  }

  loadAlulas(): void {
    this.alulaService.getAllAlulas().subscribe(
      (data) => {
        this.alulas = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes'])
  }
}