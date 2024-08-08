import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FatScoreComponent } from './fat-score.component';

describe('FatScoreComponent', () => {
  let component: FatScoreComponent;
  let fixture: ComponentFixture<FatScoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FatScoreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FatScoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
