import { TestBed } from '@angular/core/testing';

import { VerificationOfTheMetalRingService } from './verification-of-the-metal-ring.service';

describe('VerificationOfTheMetalRingService', () => {
  let service: VerificationOfTheMetalRingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VerificationOfTheMetalRingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
