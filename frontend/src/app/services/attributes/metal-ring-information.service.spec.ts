import { TestBed } from '@angular/core/testing';

import { MetalRingInformationService } from './metal-ring-information.service';

describe('MetalRingInformationService', () => {
  let service: MetalRingInformationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MetalRingInformationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
