import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarsusMethodComponent } from './tarsus-method.component';

describe('TarsusMethodComponent', () => {
  let component: TarsusMethodComponent;
  let fixture: ComponentFixture<TarsusMethodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TarsusMethodComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TarsusMethodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
