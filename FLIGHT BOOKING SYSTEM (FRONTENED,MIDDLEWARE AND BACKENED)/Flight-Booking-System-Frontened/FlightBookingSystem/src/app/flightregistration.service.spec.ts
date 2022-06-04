import { TestBed } from '@angular/core/testing';

import { FlightregistrationService } from './flightregistration.service';

describe('FlightregistrationService', () => {
  let service: FlightregistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightregistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
