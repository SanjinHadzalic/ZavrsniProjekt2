import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CatchingMethods } from '../../../interfaces/attributes/catching-methods';
import { CatchingMethodsService } from '../../../services/attributes/catching-methods.service';

@Component({
  selector: 'app-catching-methods',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './catching-methods.component.html',
  styleUrl: './catching-methods.component.css'
})
export class CatchingMethodsComponent implements OnInit {
  catchingMethods: CatchingMethods[] = [];

  constructor(private catchingMethodsService: CatchingMethodsService, private router: Router) {}

  ngOnInit(): void {
    this.loadCatchingMethods();
  }

  loadCatchingMethods(): void {
    this.catchingMethodsService.getAllCatchingMethods().subscribe(
      (data) => {
        this.catchingMethods = data;
      },
      (error) => {
        console.error('Error fetching data', error);
      }
    );
  }

  return(): void {
    this.router.navigate(['/attributes']); // Navigate back to the attributes page
  }
}