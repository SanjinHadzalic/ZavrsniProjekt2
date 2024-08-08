import { TestBed } from '@angular/core/testing';

import { MovedBeforeTheEncounterService } from './moved-before-the-encounter.service';

describe('MovedBeforeTheEncounterService', () => {
  let service: MovedBeforeTheEncounterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovedBeforeTheEncounterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
