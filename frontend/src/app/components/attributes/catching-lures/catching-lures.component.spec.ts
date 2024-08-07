import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatchingLuresComponent } from './catching-lures.component';

describe('CatchingLuresComponent', () => {
  let component: CatchingLuresComponent;
  let fixture: ComponentFixture<CatchingLuresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CatchingLuresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CatchingLuresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
