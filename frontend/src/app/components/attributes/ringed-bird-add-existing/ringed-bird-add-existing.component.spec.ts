import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingedBirdAddExistingComponent } from './ringed-bird-add-existing.component';

describe('RingedBirdAddExistingComponent', () => {
  let component: RingedBirdAddExistingComponent;
  let fixture: ComponentFixture<RingedBirdAddExistingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingedBirdAddExistingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingedBirdAddExistingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
