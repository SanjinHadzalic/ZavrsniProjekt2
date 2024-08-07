import { TestBed } from '@angular/core/testing';

import { AccuracyOfDateService } from './accuracy-of-date.service';

describe('AccuracyOfDateService', () => {
  let service: AccuracyOfDateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccuracyOfDateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
