import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerificationOfTheMetalRingComponent } from './verification-of-the-metal-ring.component';

describe('VerificationOfTheMetalRingComponent', () => {
  let component: VerificationOfTheMetalRingComponent;
  let fixture: ComponentFixture<VerificationOfTheMetalRingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerificationOfTheMetalRingComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerificationOfTheMetalRingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
