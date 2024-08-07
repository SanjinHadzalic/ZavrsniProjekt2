import { TestBed } from '@angular/core/testing';

import { AccuracyOfPullusAgeService } from './accuracy-of-pullus-age.service';

describe('AccuracyOfPullusAgeService', () => {
  let service: AccuracyOfPullusAgeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccuracyOfPullusAgeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
