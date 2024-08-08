import { TestBed } from '@angular/core/testing';

import { PlumageCodeService } from './plumage-code.service';

describe('PlumageCodeService', () => {
  let service: PlumageCodeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlumageCodeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
