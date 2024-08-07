import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CircumstancesPresumedComponent } from './circumstances-presumed.component';

describe('CircumstancesPresumedComponent', () => {
  let component: CircumstancesPresumedComponent;
  let fixture: ComponentFixture<CircumstancesPresumedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CircumstancesPresumedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CircumstancesPresumedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
