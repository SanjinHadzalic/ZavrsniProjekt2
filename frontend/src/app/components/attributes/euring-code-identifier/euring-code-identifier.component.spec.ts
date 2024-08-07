import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EuringCodeIdentifierComponent } from './euring-code-identifier.component';

describe('EuringCodeIdentifierComponent', () => {
  let component: EuringCodeIdentifierComponent;
  let fixture: ComponentFixture<EuringCodeIdentifierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EuringCodeIdentifierComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EuringCodeIdentifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
