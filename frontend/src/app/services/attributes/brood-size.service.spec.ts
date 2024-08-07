import { TestBed } from '@angular/core/testing';

import { BroodSizeService } from './brood-size.service';

describe('BroodSizeService', () => {
  let service: BroodSizeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BroodSizeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
