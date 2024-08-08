import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StateOfWingPointComponent } from './state-of-wing-point.component';

describe('StateOfWingPointComponent', () => {
  let component: StateOfWingPointComponent;
  let fixture: ComponentFixture<StateOfWingPointComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StateOfWingPointComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StateOfWingPointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
