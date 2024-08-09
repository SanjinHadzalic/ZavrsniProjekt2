import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingedBirdDetailsComponent } from './ringed-bird-details.component';

describe('RingedBirdDetailsComponent', () => {
  let component: RingedBirdDetailsComponent;
  let fixture: ComponentFixture<RingedBirdDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingedBirdDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingedBirdDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
