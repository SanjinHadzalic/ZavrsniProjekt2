import { TestBed } from '@angular/core/testing';

import { BillMethodService } from './bill-method.service';

describe('BillMethodService', () => {
  let service: BillMethodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BillMethodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
