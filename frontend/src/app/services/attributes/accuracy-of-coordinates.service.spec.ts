import { TestBed } from '@angular/core/testing';

import { AccuracyOfCoordinatesService } from './accuracy-of-coordinates.service';

describe('AccuracyOfCoordinatesService', () => {
  let service: AccuracyOfCoordinatesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccuracyOfCoordinatesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
