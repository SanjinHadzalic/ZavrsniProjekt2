import { TestBed } from '@angular/core/testing';

import { PullusAgeService } from './pullus-age.service';

describe('PullusAgeService', () => {
  let service: PullusAgeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PullusAgeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
