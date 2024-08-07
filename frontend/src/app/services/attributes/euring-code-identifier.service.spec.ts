import { TestBed } from '@angular/core/testing';

import { EuringCodeIdentifierService } from './euring-code-identifier.service';

describe('EuringCodeIdentifierService', () => {
  let service: EuringCodeIdentifierService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EuringCodeIdentifierService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
