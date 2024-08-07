import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CircumstancesComponent } from './circumstances.component';

describe('CircumstancesComponent', () => {
  let component: CircumstancesComponent;
  let fixture: ComponentFixture<CircumstancesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CircumstancesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CircumstancesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
