import { TestBed } from '@angular/core/testing';

import { FatScoreService } from './fat-score.service';

describe('FatScoreService', () => {
  let service: FatScoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FatScoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
