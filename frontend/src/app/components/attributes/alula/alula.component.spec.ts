import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlulaComponent } from './alula.component';

describe('AlulaComponent', () => {
  let component: AlulaComponent;
  let fixture: ComponentFixture<AlulaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlulaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlulaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
