import { TestBed } from '@angular/core/testing';

import { BroodPatchService } from './brood-patch.service';

describe('BroodPatchService', () => {
  let service: BroodPatchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BroodPatchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
