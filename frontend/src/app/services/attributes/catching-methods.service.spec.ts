import { TestBed } from '@angular/core/testing';

import { CatchingMethodsService } from './catching-methods.service';

describe('CatchingMethodsService', () => {
  let service: CatchingMethodsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CatchingMethodsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
