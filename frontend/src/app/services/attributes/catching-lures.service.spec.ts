import { TestBed } from '@angular/core/testing';

import { CatchingLuresService } from './catching-lures.service';

describe('CatchingLuresService', () => {
  let service: CatchingLuresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CatchingLuresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
