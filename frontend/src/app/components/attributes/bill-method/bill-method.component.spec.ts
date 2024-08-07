import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillMethodComponent } from './bill-method.component';

describe('BillMethodComponent', () => {
  let component: BillMethodComponent;
  let fixture: ComponentFixture<BillMethodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BillMethodComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BillMethodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
