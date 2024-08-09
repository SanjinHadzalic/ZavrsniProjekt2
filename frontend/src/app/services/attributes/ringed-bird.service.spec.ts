import { TestBed } from '@angular/core/testing';

import { RingedBirdService } from './ringed-bird.service';

describe('RingedBirdService', () => {
  let service: RingedBirdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RingedBirdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
