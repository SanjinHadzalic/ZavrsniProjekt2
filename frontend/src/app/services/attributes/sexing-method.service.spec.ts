import { TestBed } from '@angular/core/testing';

import { SexingMethodService } from './sexing-method.service';

describe('SexingMethodService', () => {
  let service: SexingMethodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SexingMethodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
