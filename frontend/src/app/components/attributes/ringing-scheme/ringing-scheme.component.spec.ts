import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingingSchemeComponent } from './ringing-scheme.component';

describe('RingingSchemeComponent', () => {
  let component: RingingSchemeComponent;
  let fixture: ComponentFixture<RingingSchemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingingSchemeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingingSchemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
