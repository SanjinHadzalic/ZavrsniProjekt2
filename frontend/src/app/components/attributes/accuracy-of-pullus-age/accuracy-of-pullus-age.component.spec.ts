import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccuracyOfPullusAgeComponent } from './accuracy-of-pullus-age.component';

describe('AccuracyOfPullusAgeComponent', () => {
  let component: AccuracyOfPullusAgeComponent;
  let fixture: ComponentFixture<AccuracyOfPullusAgeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccuracyOfPullusAgeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AccuracyOfPullusAgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
