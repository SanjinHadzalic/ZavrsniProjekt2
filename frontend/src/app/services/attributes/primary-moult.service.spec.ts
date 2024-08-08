import { TestBed } from '@angular/core/testing';

import { PrimaryMoultService } from './primary-moult.service';

describe('PrimaryMoultService', () => {
  let service: PrimaryMoultService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrimaryMoultService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
