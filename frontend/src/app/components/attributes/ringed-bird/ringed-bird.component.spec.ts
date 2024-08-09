import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingedBirdComponent } from './ringed-bird.component';

describe('RingedBirdComponent', () => {
  let component: RingedBirdComponent;
  let fixture: ComponentFixture<RingedBirdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingedBirdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingedBirdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
