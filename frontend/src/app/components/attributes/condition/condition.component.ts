import { Component, OnInit } from '@angular/core';
import { Condition } from '../../../interfaces/attributes/condition';
import { ConditionService } from '../../../services/attributes/condition.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-condition',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './condition.component.html',
  styleUrl: './condition.component.css'
})
export class ConditionComponent implements OnInit {
  conditions: Condition[] = [];

  constructor(private conditionService: ConditionService, private router: Router) {}

  ngOnInit(): void {
    this.loadConditions();
  }

  loadConditions(): void {
    this.conditionService.getAllConditions().subscribe(data => {
      this.conditions = data;
    });
  }

  viewDetails(id: number): void {
    this.router.navigate(['/condition', id]);
  }

  return(): void {
    this.router.navigate(['/attributes']);
  }
}