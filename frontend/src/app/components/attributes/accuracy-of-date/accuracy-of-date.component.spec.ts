import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccuracyOfDateComponent } from './accuracy-of-date.component';

describe('AccuracyOfDateComponent', () => {
  let component: AccuracyOfDateComponent;
  let fixture: ComponentFixture<AccuracyOfDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccuracyOfDateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AccuracyOfDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
