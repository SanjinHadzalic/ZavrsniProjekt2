import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingCodeAddComponent } from './ring-code-add.component';

describe('RingCodeAddComponent', () => {
  let component: RingCodeAddComponent;
  let fixture: ComponentFixture<RingCodeAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingCodeAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingCodeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
