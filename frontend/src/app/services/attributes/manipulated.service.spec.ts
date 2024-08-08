import { TestBed } from '@angular/core/testing';

import { ManipulatedService } from './manipulated.service';

describe('ManipulatedService', () => {
  let service: ManipulatedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManipulatedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
