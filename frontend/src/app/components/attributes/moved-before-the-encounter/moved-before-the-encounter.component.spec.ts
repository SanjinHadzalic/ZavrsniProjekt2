import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovedBeforeTheEncounterComponent } from './moved-before-the-encounter.component';

describe('MovedBeforeTheEncounterComponent', () => {
  let component: MovedBeforeTheEncounterComponent;
  let fixture: ComponentFixture<MovedBeforeTheEncounterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovedBeforeTheEncounterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MovedBeforeTheEncounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
