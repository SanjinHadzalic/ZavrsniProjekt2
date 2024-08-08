import { TestBed } from '@angular/core/testing';

import { PrimaryIdentificationMethodService } from './primary-identification-method.service';

describe('PrimaryIdentificationMethodService', () => {
  let service: PrimaryIdentificationMethodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrimaryIdentificationMethodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
