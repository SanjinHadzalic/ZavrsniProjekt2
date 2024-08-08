import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SexComponent } from './sex.component';

describe('SexComponent', () => {
  let component: SexComponent;
  let fixture: ComponentFixture<SexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SexComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
