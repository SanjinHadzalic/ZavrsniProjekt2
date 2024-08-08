import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoultComponent } from './moult.component';

describe('MoultComponent', () => {
  let component: MoultComponent;
  let fixture: ComponentFixture<MoultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoultComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MoultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
