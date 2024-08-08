import { TestBed } from '@angular/core/testing';

import { OtherMarksInformationService } from './other-marks-information.service';

describe('OtherMarksInformationService', () => {
  let service: OtherMarksInformationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OtherMarksInformationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
