import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherMarksInformationComponent } from './other-marks-information.component';

describe('OtherMarksInformationComponent', () => {
  let component: OtherMarksInformationComponent;
  let fixture: ComponentFixture<OtherMarksInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OtherMarksInformationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OtherMarksInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
