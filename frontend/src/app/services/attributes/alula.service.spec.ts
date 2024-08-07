import { TestBed } from '@angular/core/testing';

import { AlulaService } from './alula.service';

describe('AlulaService', () => {
  let service: AlulaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlulaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
