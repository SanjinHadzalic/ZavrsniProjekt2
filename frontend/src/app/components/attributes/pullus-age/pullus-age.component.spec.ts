import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PullusAgeComponent } from './pullus-age.component';

describe('PullusAgeComponent', () => {
  let component: PullusAgeComponent;
  let fixture: ComponentFixture<PullusAgeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PullusAgeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PullusAgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
