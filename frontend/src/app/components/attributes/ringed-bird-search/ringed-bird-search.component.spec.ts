import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RingedBirdSearchComponent } from './ringed-bird-search.component';

describe('RingedBirdSearchComponent', () => {
  let component: RingedBirdSearchComponent;
  let fixture: ComponentFixture<RingedBirdSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RingedBirdSearchComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RingedBirdSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
