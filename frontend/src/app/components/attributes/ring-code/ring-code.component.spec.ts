import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingCodeComponent } from './ring-code.component';

describe('RingCodeComponent', () => {
  let component: RingCodeComponent;
  let fixture: ComponentFixture<RingCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingCodeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
