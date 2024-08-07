import { TestBed } from '@angular/core/testing';

import { CircumstancesPresumedService } from './circumstances-presumed.service';

describe('CircumstancesPresumedService', () => {
  let service: CircumstancesPresumedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CircumstancesPresumedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
