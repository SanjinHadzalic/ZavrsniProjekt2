import { TestBed } from '@angular/core/testing';

import { CircumstancesService } from './circumstances.service';

describe('CircumstancesService', () => {
  let service: CircumstancesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CircumstancesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
