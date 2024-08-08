import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimaryIdentificationMethodComponent } from './primary-identification-method.component';

describe('PrimaryIdentificationMethodComponent', () => {
  let component: PrimaryIdentificationMethodComponent;
  let fixture: ComponentFixture<PrimaryIdentificationMethodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrimaryIdentificationMethodComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PrimaryIdentificationMethodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
