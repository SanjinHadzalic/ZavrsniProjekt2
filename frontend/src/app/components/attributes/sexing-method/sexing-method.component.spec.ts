import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SexingMethodComponent } from './sexing-method.component';

describe('SexingMethodComponent', () => {
  let component: SexingMethodComponent;
  let fixture: ComponentFixture<SexingMethodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SexingMethodComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SexingMethodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
