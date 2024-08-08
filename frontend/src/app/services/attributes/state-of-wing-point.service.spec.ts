import { TestBed } from '@angular/core/testing';

import { StateOfWingPointService } from './state-of-wing-point.service';

describe('StateOfWingPointService', () => {
  let service: StateOfWingPointService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StateOfWingPointService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
