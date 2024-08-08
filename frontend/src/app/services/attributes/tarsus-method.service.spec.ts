import { TestBed } from '@angular/core/testing';

import { TarsusMethodService } from './tarsus-method.service';

describe('TarsusMethodService', () => {
  let service: TarsusMethodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TarsusMethodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
