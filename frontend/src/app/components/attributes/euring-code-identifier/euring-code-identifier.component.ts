import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EuringCodeIdentifier } from '../../../interfaces/attributes/euring-code-identifier';
import { EURINGCodeIdentifierService } from '../../../services/attributes/euring-code-identifier.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-euring-code-identifier',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './euring-code-identifier.component.html',
  styleUrl: './euring-code-identifier.component.css'
})
export class EuringCodeIdentifierComponent implements OnInit{
  euringCodeIdentifiers: EuringCodeIdentifier[] = [];

  constructor(private euringCodeIdentifierService: EURINGCodeIdentifierService, private router: Router) {}

  ngOnInit(): void {
    this.loadEURINGCodeIdentifiers();
  }

  loadEURINGCodeIdentifiers(): void {
    this.euringCodeIdentifierService.getAllEURINGCodeIdentifier().subscribe(
      (data) => {
        this.euringCodeIdentifiers = data;
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
