import { TestBed } from '@angular/core/testing';

import { RingCodeService } from './ring-code.service';

describe('RingCodeService', () => {
  let service: RingCodeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RingCodeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
