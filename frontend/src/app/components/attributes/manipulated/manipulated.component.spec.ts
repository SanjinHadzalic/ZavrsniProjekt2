import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManipulatedComponent } from './manipulated.component';

describe('ManipulatedComponent', () => {
  let component: ManipulatedComponent;
  let fixture: ComponentFixture<ManipulatedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManipulatedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ManipulatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
