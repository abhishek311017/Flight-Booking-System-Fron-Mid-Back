import { TestBed } from '@angular/core/testing';

import { PassangerregistrationService } from './passangerregistration.service';

describe('PassangerregistrationService', () => {
  let service: PassangerregistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassangerregistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
