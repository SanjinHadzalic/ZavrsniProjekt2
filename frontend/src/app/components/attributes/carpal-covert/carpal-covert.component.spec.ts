import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarpalCovertComponent } from './carpal-covert.component';

describe('CarpalCovertComponent', () => {
  let component: CarpalCovertComponent;
  let fixture: ComponentFixture<CarpalCovertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CarpalCovertComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CarpalCovertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
