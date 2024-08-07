import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccuracyOfCoordinatesComponent } from './accuracy-of-coordinates.component';

describe('AccuracyOfCoordinatesComponent', () => {
  let component: AccuracyOfCoordinatesComponent;
  let fixture: ComponentFixture<AccuracyOfCoordinatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccuracyOfCoordinatesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AccuracyOfCoordinatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
