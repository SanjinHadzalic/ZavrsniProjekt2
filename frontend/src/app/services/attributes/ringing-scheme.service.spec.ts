import { TestBed } from '@angular/core/testing';

import { RingingSchemeService } from './ringing-scheme.service';

describe('RingingSchemeService', () => {
  let service: RingingSchemeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RingingSchemeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
