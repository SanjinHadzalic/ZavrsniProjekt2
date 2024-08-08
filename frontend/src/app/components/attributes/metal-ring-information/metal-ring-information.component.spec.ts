import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MetalRingInformationComponent } from './metal-ring-information.component';

describe('MetalRingInformationComponent', () => {
  let component: MetalRingInformationComponent;
  let fixture: ComponentFixture<MetalRingInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MetalRingInformationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MetalRingInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
