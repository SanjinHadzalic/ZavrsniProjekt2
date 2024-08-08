import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlumageCodeComponent } from './plumage-code.component';

describe('PlumageCodeComponent', () => {
  let component: PlumageCodeComponent;
  let fixture: ComponentFixture<PlumageCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlumageCodeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlumageCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
