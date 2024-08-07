import { TestBed } from '@angular/core/testing';

import { CarpalCovertService } from './carpal-covert.service';

describe('CarpalCovertService', () => {
  let service: CarpalCovertService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarpalCovertService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
