import { TestBed } from '@angular/core/testing';

import { MoultService } from './moult.service';

describe('MoultService', () => {
  let service: MoultService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MoultService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
