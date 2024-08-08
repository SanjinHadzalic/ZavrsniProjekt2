import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PectoralMuscleScoreComponent } from './pectoral-muscle-score.component';

describe('PectoralMuscleScoreComponent', () => {
  let component: PectoralMuscleScoreComponent;
  let fixture: ComponentFixture<PectoralMuscleScoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PectoralMuscleScoreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PectoralMuscleScoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
