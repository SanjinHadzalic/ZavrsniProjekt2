import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatchingMethodsComponent } from './catching-methods.component';

describe('CatchingMethodsComponent', () => {
  let component: CatchingMethodsComponent;
  let fixture: ComponentFixture<CatchingMethodsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CatchingMethodsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CatchingMethodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
