import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimaryMoultComponent } from './primary-moult.component';

describe('PrimaryMoultComponent', () => {
  let component: PrimaryMoultComponent;
  let fixture: ComponentFixture<PrimaryMoultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrimaryMoultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PrimaryMoultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
