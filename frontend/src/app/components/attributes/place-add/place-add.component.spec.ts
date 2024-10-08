import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaceAddComponent } from './place-add.component';

describe('PlaceAddComponent', () => {
  let component: PlaceAddComponent;
  let fixture: ComponentFixture<PlaceAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PlaceAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PlaceAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
