import { TestBed } from '@angular/core/testing';

import { PectoralMuscleScoreService } from './pectoral-muscle-score.service';

describe('PectoralMuscleScoreService', () => {
  let service: PectoralMuscleScoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PectoralMuscleScoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
