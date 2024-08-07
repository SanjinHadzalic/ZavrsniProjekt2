import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BroodSizeComponent } from './brood-size.component';

describe('BroodSizeComponent', () => {
  let component: BroodSizeComponent;
  let fixture: ComponentFixture<BroodSizeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BroodSizeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BroodSizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
