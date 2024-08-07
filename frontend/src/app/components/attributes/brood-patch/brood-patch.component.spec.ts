import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BroodPatchComponent } from './brood-patch.component';

describe('BroodPatchComponent', () => {
  let component: BroodPatchComponent;
  let fixture: ComponentFixture<BroodPatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BroodPatchComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BroodPatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
